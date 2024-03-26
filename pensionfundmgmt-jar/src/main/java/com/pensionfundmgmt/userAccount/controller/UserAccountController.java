package com.pensionfundmgmt.userAccount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pensionfundmgmt.personalinfo.dao.PersonalInfoDao;
import com.pensionfundmgmt.personalinfo.model.PersonalInfo;
import com.pensionfundmgmt.rules.exception.RulesEngineException;

@RestController
public class UserAccountController {
	 @Autowired
	 private PersonalInfoDao userAccountDao;
	     

	@GetMapping("/userAccount")
	public List<PersonalInfo> getAllEmployees() throws RulesEngineException {
			return userAccountDao.findAll();
	}

}