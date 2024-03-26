package com.pensionfundmgmt.aggregate.repository;

import com.pensionfundmgmt.aggregate.request.AggregateRequest
import com.pensionfundmgmt.constants.RequestType
import com.pensionfundmgmt.constants.RulesDataConstants
import com.pensionfundmgmt.constants.WorkflowConstants
import com.pensionfundmgmt.groovy.RulesData;
import com.pensionfundmgmt.rules.exception.RulesEngineException;

import groovy.transform.CompileStatic;

@CompileStatic
class AggregateRepository {

	def getWorkflow(RulesData data) throws RulesEngineException, Throwable {
		AggregateRequest aggregateRequest = (AggregateRequest)data.get(RulesDataConstants.AGGREGATE_REQUEST);
		if(RequestType.ACCOUNT_INFO.equalsIgnoreCase(aggregateRequest.getRequestType())) {
			data.put(RulesDataConstants.AGGREGATE_WORKFLOW, WorkflowConstants.INFO_REQUEST_WORKFLOW);
		}
	}
}