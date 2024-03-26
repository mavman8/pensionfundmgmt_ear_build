package com.pensionfundmgmt.employee.repository;
	
import com.pensionfundmgmt.constants.EmployeeConstants;
import com.pensionfundmgmt.employee.model.Employee;
import com.pensionfundmgmt.groovy.RulesData;
import com.pensionfundmgmt.rules.exception.RulesEngineException;

import groovy.transform.CompileStatic;
	
@CompileStatic
class EmployeeRepository {
		
	def getEmployee1(RulesData data) throws RulesEngineException, Throwable {
		Employee employee = new Employee();
		employee.setEmailId("A");
		employee.setLastName("A");
		employee.setFirstName("C");
		data.put(EmployeeConstants.EMPLOYEE1, employee);
	}
	
	def getEmployee2(RulesData data) throws RulesEngineException, Throwable {
		Employee employee = new Employee();
		employee.setEmailId("A2");
		employee.setLastName("A");
		employee.setFirstName("C");
		data.put(EmployeeConstants.EMPLOYEE2, employee);
	}
	
	def getEmployee3(RulesData data) throws RulesEngineException, Throwable {
		Employee employee = new Employee();
		employee.setEmailId("A3");
		employee.setLastName("A");
		employee.setFirstName("C");
		data.put(EmployeeConstants.EMPLOYEE3, employee);
	}
		
		
		
		
		
		
	
	}