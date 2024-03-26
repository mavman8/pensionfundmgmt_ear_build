package com.pensionfundmgmt.personalinfo.repository;

import org.springframework.context.ApplicationContext

import com.pensionfundmgmt.aggregate.request.AggregateRequest
import com.pensionfundmgmt.constants.RepositoryConstants
import com.pensionfundmgmt.constants.RulesDataConstants
import com.pensionfundmgmt.groovy.Rules
import com.pensionfundmgmt.groovy.RulesConfig
import com.pensionfundmgmt.groovy.RulesData;
import com.pensionfundmgmt.groovy.RulesEngine
import com.pensionfundmgmt.rules.exception.RulesEngineException;
import com.pensionfundmgmt.schemainfo.model.SchemeInfo
import com.pensionfundmgmt.schemeinfo.dao.SchemeInfoDao

import groovy.transform.CompileStatic;

@CompileStatic
class BankSchemeRepository {

	def getBankInfo(RulesData data) throws RulesEngineException, Throwable {
		ApplicationContext applicationContext = (ApplicationContext)data.get(RulesDataConstants.APPLICATION_CONTEXT);
		RulesEngine rulesEngine = (RulesEngine)applicationContext.getBean("rulesEngine");
		Rules rules = new Rules();
		rules.add(new RulesConfig(RepositoryConstants.BANK_INFO_REPOSITORY, RepositoryConstants.GET_ACCOUNT_NUMBER));
		rules.add(new RulesConfig(RepositoryConstants.BANK_INFO_REPOSITORY, RepositoryConstants.GET_BANK_BRANCH));
		rules.add(new RulesConfig(RepositoryConstants.BANK_INFO_REPOSITORY, RepositoryConstants.GET_BANK_NAME));
		rules.add(new RulesConfig(RepositoryConstants.BANK_INFO_REPOSITORY, RepositoryConstants.GET_BANK_ADDRESS));
		rules.add(new RulesConfig(RepositoryConstants.BANK_INFO_REPOSITORY, RepositoryConstants.GET_IFSC_CODE));
		data = rulesEngine.executeSequentialRules(rules,data);
	}
	
	def getSchemes(RulesData data) throws RulesEngineException, Throwable {
		ApplicationContext applicationContext = (ApplicationContext)data.get(RulesDataConstants.APPLICATION_CONTEXT);
		AggregateRequest AggregateRequest = (AggregateRequest)data.get(RulesDataConstants.AGGREGATE_REQUEST);
		SchemeInfoDao schemeInfoDao = (SchemeInfoDao)applicationContext.getBean("schemeInfoDao");
		List<SchemeInfo> schemeList = schemeInfoDao.findAll();
		data.put(RulesDataConstants.BANK_SCHEMES, schemeList);
	}
	
	def getPrefferedScheme(RulesData data) throws RulesEngineException, Throwable {
		ApplicationContext applicationContext = (ApplicationContext)data.get(RulesDataConstants.APPLICATION_CONTEXT);
		AggregateRequest AggregateRequest = (AggregateRequest)data.get(RulesDataConstants.AGGREGATE_REQUEST);
		SchemeInfoDao schemeInfoDao = (SchemeInfoDao)applicationContext.getBean("schemeInfoDao");
		List<SchemeInfo> schemeList = schemeInfoDao.findAll();
		for(SchemeInfo scheme:schemeList) {
			if(null!= scheme && scheme.isIsPreferred()) {
				data.put(RulesDataConstants.BANK_PREFFERED_SCHEMES, scheme);
				break;
			}
		}
	}
}