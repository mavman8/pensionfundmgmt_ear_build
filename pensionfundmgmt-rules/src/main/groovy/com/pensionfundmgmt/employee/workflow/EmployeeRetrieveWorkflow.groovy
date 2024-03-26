package com.pensionfundmgmt.employee.workflow;

import com.pensionfundmgmt.groovy.Rules;
import com.pensionfundmgmt.groovy.RulesConfig;

import groovy.transform.CompileStatic;

@CompileStatic
class EmployeeRetrieveWorkflow extends BaseWorkflow{

	public Rules retrieveEmployeeData() {

		Rules rules = new Rules();
		rules.add(new RulesConfig("employee.retrieve.repository", "getEmployee1"));
		rules.add(new RulesConfig("employee.retrieve.repository", "getEmployee2"));
		rules.add(new RulesConfig("employee.retrieve.repository", "getEmployee3"));
		return rules;
	}
}