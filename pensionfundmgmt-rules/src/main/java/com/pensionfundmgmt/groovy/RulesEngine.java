package com.pensionfundmgmt.groovy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.beans.BeansException;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.stereotype.Component;

import com.pensionfundmgmt.rules.exception.RulesEngineException;

import groovy.lang.GroovyObject;

@Component
public class RulesEngine {
	GenericGroovyApplicationContext context;
	private static final String RESULT = "Result";
	
	Executor executor = Executors.newFixedThreadPool(10);

	public RulesEngine() throws RulesEngineException {
		try {
			context = new GenericGroovyApplicationContext();
			context.load("context/ruleContext.xml");
			context.refresh();
			System.out.println(context.getBean("employee.retrieve.workflow"));
		} catch (BeansException | IllegalStateException e) {
			e.printStackTrace();
			throw new RulesEngineException(e.getMessage());
		}
	}

	public Object getBeanFromConext(String beanId) {
		return context.getBean(beanId);
	}

	public Object executeRule(String repositoryId, String ruleName, Object... data) throws RulesEngineException {
		Object ruleReturn = null;
		try {
			GroovyObject repository = (GroovyObject) getBeanFromConext(repositoryId);
			ruleReturn = repository.invokeMethod(ruleName, data);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new RulesEngineException(t.getMessage(), t);
		}
		return ruleReturn;
	}

	public RulesData executeWorkflow(String workflowId, String name, RulesData ruleData) throws RulesEngineException {
		try {
			GroovyObject workflow = (GroovyObject) getBeanFromConext(workflowId);
			if (null != workflow) {
				if (isConcurrentWorkflow(workflow)) {
					ruleData = executeConcurrentWorkflow(workflow, name, ruleData);
				} else {
					ruleData = executeSequentialWorkflow(workflow, name, ruleData);
				}
			}

		} catch (Throwable t) {
			t.printStackTrace();
			throw new RulesEngineException(t.getMessage(), t);
		}
		return ruleData;

	}

	private RulesData executeSequentialWorkflow(GroovyObject workflow, String name, RulesData ruleData)
			throws RulesEngineException {
		try {
			Rules rules = (Rules) workflow.invokeMethod(name, null);
			for (RulesConfig config : rules.values()) {
				executeRule(config.getRepositoryId(), config.getRuleName(), ruleData);
			}
		} catch (Throwable t) {
			t.printStackTrace();
			throw new RulesEngineException(t.getMessage(), t);
		}
		return ruleData;
	}
	
	public RulesData executeSequentialRules(Rules rules, RulesData ruleData)
			throws RulesEngineException {
		try {
			for (RulesConfig config : rules.values()) {
				executeRule(config.getRepositoryId(), config.getRuleName(), ruleData);
			}
		} catch (Throwable t) {
			t.printStackTrace();
			throw new RulesEngineException(t.getMessage(), t);
		}
		return ruleData;
	}

	private RulesData executeConcurrentWorkflow(GroovyObject workflow, String name, RulesData ruleData)
			throws RulesEngineException {

		try {
			List<CompletableFuture<Object>> futuresList = new ArrayList<CompletableFuture<Object>>();
			Rules rules = (Rules) workflow.invokeMethod(name, null);
			for (RulesConfig config : rules.values()) {
				CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {
					try {
						return executeRule(config.getRepositoryId(), config.getRuleName(), ruleData);
					} catch (RulesEngineException e) {
						e.printStackTrace();
					}
					return null;
				}, executor);
				futuresList.add(future);

			}
			List<Object> results  = futuresList
			        .stream()
			        .map(CompletableFuture::join)
			        .filter(Objects::nonNull)
			        .collect(Collectors.toList());
			
			int i=0;
			for(Object result:results) {
				ruleData.put(name+RESULT+i, result);
			}
//			CompletableFuture<Void> allFutures = CompletableFuture
//					.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));
//			
//			List<Object> a =	allFutures.exceptionally(ex -> {
//				System.out.println("Exception occurred: " + ex.getMessage());
//				return null; // Default value to return if there's an exception
//			}).thenRun(() -> { return futuresList.stream().map(future -> future.join()).collect(Collectors.<Object>toList());});
		} catch (Throwable t) {
			t.printStackTrace();
			throw new RulesEngineException(t.getMessage(), t);
		}
		return ruleData;
	}

	public RulesData executeRulesConcurrently(Rules rules, RulesData ruleData)
			throws RulesEngineException {

		try {
			List<CompletableFuture<Object>> futuresList = new ArrayList<CompletableFuture<Object>>();
			for (RulesConfig config : rules.values()) {
				CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {
					try {
						return executeRule(config.getRepositoryId(), config.getRuleName(), ruleData);
					} catch (RulesEngineException e) {
						e.printStackTrace();
					}
					return null;
				}, executor);
				futuresList.add(future);

			}
			List<Object> results  = futuresList
			        .stream()
			        .map(CompletableFuture::join)
			        .filter(Objects::nonNull)
			        .collect(Collectors.toList());
			
//			int i=0;
//			for(Object result:results) {
//				ruleData.put(name+RESULT+i, result);
//			}
//			CompletableFuture<Void> allFutures = CompletableFuture
//					.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));
//			
//			List<Object> a =	allFutures.exceptionally(ex -> {
//				System.out.println("Exception occurred: " + ex.getMessage());
//				return null; // Default value to return if there's an exception
//			}).thenRun(() -> { return futuresList.stream().map(future -> future.join()).collect(Collectors.<Object>toList());});
		} catch (Throwable t) {
			t.printStackTrace();
			throw new RulesEngineException(t.getMessage(), t);
		}
		return ruleData;
	}
	private boolean isConcurrentWorkflow(GroovyObject workflow) throws RulesEngineException {
		Boolean isConcurrentWorkflow = Boolean.FALSE;
		try {
			isConcurrentWorkflow = (Boolean) workflow.invokeMethod("isConcurrentWorkflow", null);
		} catch (Throwable t) {
			t.printStackTrace();
			throw new RulesEngineException(t.getMessage(), t);
		}
		return isConcurrentWorkflow.booleanValue();
	}

}
