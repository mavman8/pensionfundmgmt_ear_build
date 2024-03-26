package com.pensionfundmgmt.aggregate.response;

import java.util.List;

import com.pensionfundmgmt.bankinfo.model.BankInfo;
import com.pensionfundmgmt.personalinfo.model.PersonalInfo;
import com.pensionfundmgmt.schemainfo.model.SchemeInfo;

public class InfoServiceResponse {

	private PersonalInfo personalInfo;
	private BankInfo bankInfo;

	private List<SchemeInfo> schemes;

	private SchemeInfo preferredScheme;

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public BankInfo getBankInfo() {
		return bankInfo;
	}

	public void setBankInfo(BankInfo bankInfo) {
		this.bankInfo = bankInfo;
	}

	public List<SchemeInfo> getSchemes() {
		return schemes;
	}

	public void setSchemes(List<SchemeInfo> schemes) {
		this.schemes = schemes;
	}

	public SchemeInfo getPreferredScheme() {
		return preferredScheme;
	}

	public void setPreferredScheme(SchemeInfo preferredScheme) {
		this.preferredScheme = preferredScheme;
	}

	
}
