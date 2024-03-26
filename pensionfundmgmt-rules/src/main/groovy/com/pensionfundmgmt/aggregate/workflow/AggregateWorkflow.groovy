package com.pensionfundmgmt.aggregate.workflow;

import com.pensionfundmgmt.constants.RepositoryConstants
import com.pensionfundmgmt.groovy.Rules;
import com.pensionfundmgmt.groovy.RulesConfig;
import com.pensionfundmgmt.base.workflow.BaseWorkflow;

import groovy.transform.CompileStatic;

@CompileStatic
class AggregateWorkflow extends BaseWorkflow{

	public Rules getWorkflow() {
		
		Rules rules = new Rules();
		rules.add(new RulesConfig(RepositoryConstants.AGGREGATE_REPOSITORY, RepositoryConstants.GET_WORKFLOW));
		return rules;
	}

}