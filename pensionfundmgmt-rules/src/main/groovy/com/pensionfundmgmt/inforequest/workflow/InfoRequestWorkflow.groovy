package com.pensionfundmgmt.inforequest.workflow;

import com.pensionfundmgmt.groovy.Rules;
import com.pensionfundmgmt.groovy.RulesConfig;
import com.pensionfundmgmt.base.workflow.BaseWorkflow;
import com.pensionfundmgmt.constants.RepositoryConstants

import groovy.transform.CompileStatic;

@CompileStatic
class InfoRequestWorkflow extends BaseWorkflow{

	public Rules startWorkflow() {
		setConcurrentWorkflow(true);
		Rules rules = new Rules();
		rules.add(new RulesConfig(RepositoryConstants.INFO_REQUEST_REPOSITORY, RepositoryConstants.GET_PERSONAL_INFO));
		rules.add(new RulesConfig(RepositoryConstants.INFO_REQUEST_REPOSITORY, RepositoryConstants.GET_BANK_SCHEMA));
		rules.add(new RulesConfig(RepositoryConstants.INFO_REQUEST_REPOSITORY, RepositoryConstants.AGGREGATE_INFO_RESPONSE));
		return rules;
	}

}