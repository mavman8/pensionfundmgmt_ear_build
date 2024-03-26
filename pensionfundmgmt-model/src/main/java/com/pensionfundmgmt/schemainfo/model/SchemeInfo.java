package com.pensionfundmgmt.schemainfo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SchemeInfo")
public class SchemeInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schemeId;

	private String SchemeName;

	public int getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
	}

	public String getSchemeName() {
		return SchemeName;
	}

	public void setSchemeName(String schemeName) {
		SchemeName = schemeName;
	}

	public String getFundManagerName() {
		return FundManagerName;
	}

	public void setFundManagerName(String fundManagerName) {
		FundManagerName = fundManagerName;
	}

	public int getPercantageContribution() {
		return PercantageContribution;
	}

	public void setPercantageContribution(int percantageContribution) {
		PercantageContribution = percantageContribution;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public Date getExitDate() {
		return ExitDate;
	}

	public void setExitDate(Date exitDate) {
		ExitDate = exitDate;
	}

	public boolean isIsPreferred() {
		return IsPreferred;
	}

	public void setIsPreferred(boolean isPreferred) {
		IsPreferred = isPreferred;
	}

	private String FundManagerName;

	private int PercantageContribution;

	private Date CreatedDate;

	private Date ExitDate;

	private boolean IsPreferred;

}