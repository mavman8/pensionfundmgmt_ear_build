package com.pensionfundmgmt.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pensionfundmgmt.constants.EmployeeConstants;
import com.pensionfundmgmt.employee.model.Employee;
import com.pensionfundmgmt.groovy.RulesData;
import com.pensionfundmgmt.groovy.RulesEngine;
import com.pensionfundmgmt.rules.exception.RulesEngineException;

@RestController
public class EmployeeController {
	@Autowired
	RulesEngine rulesEngine;

	@GetMapping("/employees")
		public List<Employee> getAllEmployees() throws RulesEngineException {
			List<Employee> eList=new ArrayList<>();
			RulesData rulesData = new RulesData();
			rulesData = rulesEngine.executeWorkflow("employee.retrieve.workflow", "retrieveEmployeeData", rulesData);		
			eList.add((Employee) rulesData.get(EmployeeConstants.EMPLOYEE1));
			eList.add((Employee) rulesData.get(EmployeeConstants.EMPLOYEE2));
			eList.add((Employee) rulesData.get(EmployeeConstants.EMPLOYEE3));
			return eList;
		}

	@GetMapping("/employeesConcurrently")
	public List<Employee> getAllEmployeesConcurrently() throws RulesEngineException {
		List<Employee> eList=new ArrayList<>();
		RulesData rulesData = new RulesData();
		rulesData = rulesEngine.executeWorkflow("employee.retrieve.workflow", "retrieveEmployeeData", rulesData);		
		eList.add((Employee) rulesData.get(EmployeeConstants.EMPLOYEE1));
		eList.add((Employee) rulesData.get(EmployeeConstants.EMPLOYEE2));
		eList.add((Employee) rulesData.get(EmployeeConstants.EMPLOYEE3));
		return eList;
	}
}