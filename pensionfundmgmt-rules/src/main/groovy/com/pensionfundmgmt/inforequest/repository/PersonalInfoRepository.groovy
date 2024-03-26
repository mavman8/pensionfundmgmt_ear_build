package com.pensionfundmgmt.personalinfo.repository;
	
import org.springframework.context.ApplicationContext

import com.pensionfundmgmt.aggregate.request.AggregateRequest
import com.pensionfundmgmt.constants.EmployeeConstants;
import com.pensionfundmgmt.constants.RulesDataConstants
import com.pensionfundmgmt.employee.model.Employee;
import com.pensionfundmgmt.groovy.RulesData;
import com.pensionfundmgmt.personalinfo.dao.PersonalInfoDao
import com.pensionfundmgmt.personalinfo.model.PersonalInfo
import com.pensionfundmgmt.rules.exception.RulesEngineException;

import groovy.transform.CompileStatic;
	
@CompileStatic
class PersonalInfoRepository {
		
	def getMobileInfo(RulesData data) throws RulesEngineException, Throwable {
		ApplicationContext applicationContext = (ApplicationContext)data.get(RulesDataConstants.APPLICATION_CONTEXT);
		AggregateRequest AggregateRequest = (AggregateRequest)data.get(RulesDataConstants.AGGREGATE_REQUEST);
		PersonalInfoDao personalInfoDao = (PersonalInfoDao)applicationContext.getBean("personalInfoDao");
		PersonalInfo personalInfo = personalInfoDao.findById(AggregateRequest.getUniqueId()).get();
		data.put(RulesDataConstants.MOBILE, personalInfo.getMobile());
	}
	
	def getAddressInfo(RulesData data) throws RulesEngineException, Throwable {
		ApplicationContext applicationContext = (ApplicationContext)data.get(RulesDataConstants.APPLICATION_CONTEXT);
		AggregateRequest AggregateRequest = (AggregateRequest)data.get(RulesDataConstants.AGGREGATE_REQUEST);
		PersonalInfoDao personalInfoDao = (PersonalInfoDao)applicationContext.getBean("personalInfoDao");
		PersonalInfo personalInfo = personalInfoDao.findById(AggregateRequest.getUniqueId()).get();
		data.put(RulesDataConstants.CITY, personalInfo.getCity());
		data.put(RulesDataConstants.ADDRESS1, personalInfo.getAddress1());
		data.put(RulesDataConstants.ADDRESS2, personalInfo.getAddress2());
		data.put(RulesDataConstants.PINCODE, personalInfo.getPinCode());
	}
	
	def getBasicUserInfo(RulesData data) throws RulesEngineException, Throwable {
		ApplicationContext applicationContext = (ApplicationContext)data.get(RulesDataConstants.APPLICATION_CONTEXT);
		AggregateRequest AggregateRequest = (AggregateRequest)data.get(RulesDataConstants.AGGREGATE_REQUEST);
		PersonalInfoDao personalInfoDao = (PersonalInfoDao)applicationContext.getBean("personalInfoDao");
		PersonalInfo personalInfo = personalInfoDao.findById(AggregateRequest.getUniqueId()).get();
		data.put(RulesDataConstants.FULLNAME, personalInfo.getFullName());
		data.put(RulesDataConstants.NATIONALITY, personalInfo.getNationality());
		data.put(RulesDataConstants.MOTHERS_NAME, personalInfo.getMothersName());
		data.put(RulesDataConstants.FATHERS_NAME, personalInfo.getFathersName());
		data.put(RulesDataConstants.DOB, personalInfo.getDateOfBirth());
	}
		
	def getKycInfo(RulesData data) throws RulesEngineException, Throwable {
		ApplicationContext applicationContext = (ApplicationContext)data.get(RulesDataConstants.APPLICATION_CONTEXT);
		AggregateRequest AggregateRequest = (AggregateRequest)data.get(RulesDataConstants.AGGREGATE_REQUEST);
		PersonalInfoDao personalInfoDao = (PersonalInfoDao)applicationContext.getBean("personalInfoDao");
		PersonalInfo personalInfo = personalInfoDao.findById(AggregateRequest.getUniqueId()).get();
		data.put(RulesDataConstants.KYC, personalInfo.isKycDone());
	}
	
		
		
		
		
	
	}