package com.pensionfundmgmt.aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pensionfundmgmt.aggregate.request.AggregateRequest;
import com.pensionfundmgmt.aggregate.response.AggregateResponse;
import com.pensionfundmgmt.constants.RulesDataConstants;
import com.pensionfundmgmt.constants.WorkflowConstants;
import com.pensionfundmgmt.groovy.RulesData;
import com.pensionfundmgmt.groovy.RulesEngine;
import com.pensionfundmgmt.rules.exception.RulesEngineException;

@RestController
public class AggregateController {
	@Autowired
	RulesEngine rulesEngine;

	@Autowired
	private ApplicationContext applicationContext;

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@PostMapping(value = "/getData",consumes = "application/json")
	public AggregateResponse getData(@RequestBody AggregateRequest aggregateRequest) throws RulesEngineException {
		RulesData rulesData = new RulesData();
		rulesData.put(RulesDataConstants.AGGREGATE_REQUEST, aggregateRequest);
		rulesData.put(RulesDataConstants.APPLICATION_CONTEXT, applicationContext);
		System.out.println("calling workflow"+aggregateRequest.getRequestType());
		// Get Workflow based on RequestID
		rulesData = rulesEngine.executeWorkflow(WorkflowConstants.AGGREGATE_WORKFLOW, WorkflowConstants.GET_WORKFLOW,
				rulesData);
		System.out.println("2::"+(String) rulesData.get(RulesDataConstants.AGGREGATE_WORKFLOW));
		// Start Workflow
		if (rulesData.containsKey(RulesDataConstants.AGGREGATE_WORKFLOW)) {
			rulesData = rulesEngine.executeWorkflow((String) rulesData.get(RulesDataConstants.AGGREGATE_WORKFLOW),
					WorkflowConstants.START_WORKFLOW, rulesData);
		}

		return (AggregateResponse) rulesData.get(RulesDataConstants.AGGREGATE_RESPONSE) == null ? null
				: (AggregateResponse) rulesData.get(RulesDataConstants.AGGREGATE_RESPONSE);
	}

}