package com.pensionfundmgmt.inforequest.repository;

import org.springframework.context.ApplicationContext

import com.pensionfundmgmt.aggregate.response.AggregateResponse
import com.pensionfundmgmt.aggregate.response.InfoServiceResponse
import com.pensionfundmgmt.bankinfo.model.BankInfo
import com.pensionfundmgmt.constants.RepositoryConstants
import com.pensionfundmgmt.constants.RulesDataConstants
import com.pensionfundmgmt.groovy.Rules
import com.pensionfundmgmt.groovy.RulesConfig
import com.pensionfundmgmt.groovy.RulesData
import com.pensionfundmgmt.groovy.RulesEngine
import com.pensionfundmgmt.personalinfo.model.PersonalInfo
import com.pensionfundmgmt.rules.exception.RulesEngineException
import com.pensionfundmgmt.schemainfo.model.SchemeInfo

import groovy.transform.CompileStatic;

@CompileStatic
class InfoRequestRepository {

	def getPersonalInfo(RulesData data) throws RulesEngineException, Throwable {
		ApplicationContext applicationContext = (ApplicationContext)data.get(RulesDataConstants.APPLICATION_CONTEXT);
		RulesEngine rulesEngine = (RulesEngine)applicationContext.getBean("rulesEngine");
		Rules rules = new Rules();
		rules.add(new RulesConfig(RepositoryConstants.PERSONAL_INFO_REPOSITORY, RepositoryConstants.GET_MOBILE_INFO));
		rules.add(new RulesConfig(RepositoryConstants.PERSONAL_INFO_REPOSITORY, RepositoryConstants.GET_ADDRESS_INFO));
		rules.add(new RulesConfig(RepositoryConstants.PERSONAL_INFO_REPOSITORY, RepositoryConstants.GET_BASIC_USER_INFO));
		rules.add(new RulesConfig(RepositoryConstants.PERSONAL_INFO_REPOSITORY, RepositoryConstants.GET_KYC_INFO));
		data = rulesEngine.executeSequentialRules(rules,data);
	}
	def getBankSchema(RulesData data) throws RulesEngineException, Throwable {
		ApplicationContext applicationContext = (ApplicationContext)data.get(RulesDataConstants.APPLICATION_CONTEXT);
		RulesEngine rulesEngine = (RulesEngine)applicationContext.getBean("rulesEngine");
		Rules rules = new Rules();
		rules.add(new RulesConfig(RepositoryConstants.BANK_SCHEME_REPOSITORY, RepositoryConstants.GET_BANK_INFO));
		rules.add(new RulesConfig(RepositoryConstants.BANK_SCHEME_REPOSITORY, RepositoryConstants.GET_BANK_SCHEMES));
		rules.add(new RulesConfig(RepositoryConstants.BANK_SCHEME_REPOSITORY, RepositoryConstants.GET_BANK_PREFERRED_SCHEME));
		rules.add(new RulesConfig(RepositoryConstants.BANK_SCHEME_REPOSITORY, RepositoryConstants.GET_BANK_SCHEMES));
		data = rulesEngine.executeSequentialRules(rules,data);
	}



	def aggregateInfoResponse(RulesData data) throws RulesEngineException, Throwable {
		AggregateResponse aggregateResponse= new AggregateResponse();
		InfoServiceResponse infoServiceResponse =  new InfoServiceResponse();
		infoServiceResponse.setPersonalInfo(aggregatePersonalInfo(data));
		infoServiceResponse.setBankInfo(aggregateBankInfo(data));
		infoServiceResponse.setPreferredScheme((SchemeInfo)data.get(RulesDataConstants.BANK_PREFFERED_SCHEMES));
		infoServiceResponse.setSchemes((List<SchemeInfo>)data.get(RulesDataConstants.BANK_SCHEMES))
		aggregateResponse.setAccountInfoResponse(infoServiceResponse);
		data.put(RulesDataConstants.AGGREGATE_RESPONSE, aggregateResponse);
	}
	
	def PersonalInfo aggregatePersonalInfo(RulesData data) throws RulesEngineException, Throwable {
		PersonalInfo personalInfo= new PersonalInfo();
		personalInfo.setAddress1((String)data.get(RulesDataConstants.ADDRESS1));
		personalInfo.setAddress2((String)data.get(RulesDataConstants.ADDRESS2));
		personalInfo.setCity((String)data.get(RulesDataConstants.CITY));
		personalInfo.setDateOfBirth((Date)data.get(RulesDataConstants.DOB));
		personalInfo.setFathersName((String)data.get(RulesDataConstants.FATHERS_NAME));
		personalInfo.setMothersName((String)data.get(RulesDataConstants.MOTHERS_NAME));
		personalInfo.setFullName((String)data.get(RulesDataConstants.FULLNAME));
		personalInfo.setKycDone((Boolean)data.get(RulesDataConstants.KYC));
		personalInfo.setMobile((String)data.get(RulesDataConstants.MOBILE));
		personalInfo.setNationality((String)data.get(RulesDataConstants.NATIONALITY));
		personalInfo.setPinCode((Integer)data.get(RulesDataConstants.PINCODE));
		return personalInfo;
	}
	
	def BankInfo aggregateBankInfo(RulesData data) throws RulesEngineException, Throwable {
		BankInfo bankInfo= new BankInfo();
		bankInfo.setAccountNumber((Integer)data.get(RulesDataConstants.ACCOUNT_NUMBER));
		bankInfo.setAddress((String)data.get(RulesDataConstants.BANK_ADDRESS));
		bankInfo.setBankBranch((String)data.get(RulesDataConstants.BANK_BRANCH));
		bankInfo.setBankName((String)data.get(RulesDataConstants.BANK_NAME));
		bankInfo.setIfscCode((String)data.get(RulesDataConstants.IFSC_CODE));
		return bankInfo;		
	}
}	