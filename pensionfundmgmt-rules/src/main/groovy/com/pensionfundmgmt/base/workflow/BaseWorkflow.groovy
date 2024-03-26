package com.pensionfundmgmt.base.workflow;

import com.pensionfundmgmt.groovy.Rules;
import com.pensionfundmgmt.groovy.RulesConfig;

import groovy.transform.CompileStatic;

@CompileStatic
class BaseWorkflow {

	private boolean isConcurrentWorkflow = false;

	public boolean isConcurrentWorkflow() {
		return isConcurrentWorkflow;
	}

	public void setConcurrentWorkflow(boolean isConcurrentWorkflow) {
		this.isConcurrentWorkflow = isConcurrentWorkflow;
	}
}