package com.pensionfundmgmt.personalinfo.repository;
	
import org.springframework.context.ApplicationContext

import com.pensionfundmgmt.aggregate.request.AggregateRequest
import com.pensionfundmgmt.bankinfo.dao.BankInfoDao
import com.pensionfundmgmt.bankinfo.model.BankInfo
import com.pensionfundmgmt.constants.RulesDataConstants
import com.pensionfundmgmt.groovy.RulesData;
import com.pensionfundmgmt.personalinfo.dao.PersonalInfoDao
import com.pensionfundmgmt.personalinfo.model.PersonalInfo
import com.pensionfundmgmt.rules.exception.RulesEngineException;

import groovy.transform.CompileStatic;
	
@CompileStatic
class BankInfoRepository {
		
	def getAccountNumber(RulesData data) throws RulesEngineException, Throwable {
		ApplicationContext applicationContext = (ApplicationContext)data.get(RulesDataConstants.APPLICATION_CONTEXT);
		AggregateRequest AggregateRequest = (AggregateRequest)data.get(RulesDataConstants.AGGREGATE_REQUEST);
		BankInfoDao bankInfoDao = (BankInfoDao)applicationContext.getBean("bankInfoDao");
		BankInfo bankInfo = bankInfoDao.findById(AggregateRequest.getUniqueId()).get();
		data.put(RulesDataConstants.ACCOUNT_NUMBER, bankInfo.getAccountNumber());
	}
	
	def getBankBranch(RulesData data) throws RulesEngineException, Throwable {
		ApplicationContext applicationContext = (ApplicationContext)data.get(RulesDataConstants.APPLICATION_CONTEXT);
		AggregateRequest AggregateRequest = (AggregateRequest)data.get(RulesDataConstants.AGGREGATE_REQUEST);
		BankInfoDao bankInfoDao = (BankInfoDao)applicationContext.getBean("bankInfoDao");
		BankInfo bankInfo = bankInfoDao.findById(AggregateRequest.getUniqueId()).get();
		data.put(RulesDataConstants.BANK_BRANCH, bankInfo.getBankBranch());
	}
	
	def getBankName(RulesData data) throws RulesEngineException, Throwable {
//		ApplicationContext applicationContext = (ApplicationContext)data.get(RulesDataConstants.APPLICATION_CONTEXT);
//		AggregateRequest AggregateRequest = (AggregateRequest)data.get(RulesDataConstants.AGGREGATE_REQUEST);
//		BankInfoDao bankInfoDao = (BankInfoDao)applicationContext.getBean("bankInfoDao");
//		BankInfo bankInfo = bankInfoDao.findById(AggregateRequest.getUniqueId()).get();
//		data.put(RulesDataConstants.BANK_NAME, bankInfo.getBankName());
	}
	
	def getBankAddress(RulesData data) throws RulesEngineException, Throwable {
		ApplicationContext applicationContext = (ApplicationContext)data.get(RulesDataConstants.APPLICATION_CONTEXT);
		AggregateRequest AggregateRequest = (AggregateRequest)data.get(RulesDataConstants.AGGREGATE_REQUEST);
		BankInfoDao bankInfoDao = (BankInfoDao)applicationContext.getBean("bankInfoDao");
		BankInfo bankInfo = bankInfoDao.findById(AggregateRequest.getUniqueId()).get();
		data.put(RulesDataConstants.BANK_ADDRESS, bankInfo.getAddress());
	}
		
	def getIfscCode(RulesData data) throws RulesEngineException, Throwable {
		ApplicationContext applicationContext = (ApplicationContext)data.get(RulesDataConstants.APPLICATION_CONTEXT);
		AggregateRequest AggregateRequest = (AggregateRequest)data.get(RulesDataConstants.AGGREGATE_REQUEST);
		BankInfoDao bankInfoDao = (BankInfoDao)applicationContext.getBean("bankInfoDao");
		BankInfo bankInfo = bankInfoDao.findById(AggregateRequest.getUniqueId()).get();
		data.put(RulesDataConstants.IFSC_CODE, bankInfo.getIfscCode());
	}
	
		
		
		
		
	
	}