package com.pensionfundmgmt.groovy;

public class RulesConfig 
{
	private String repositoryId;
	private String ruleName;
	public String getRepositoryId() {
		return repositoryId;
	}
	public void setRepositoryId(String repositoryId) {
		this.repositoryId = repositoryId;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	
	public RulesConfig(String repositoryId, String ruleName) {
		this.repositoryId=repositoryId;
		this.ruleName=ruleName;
	}
}
