package com.pensionfundmgmt.groovy;
import java.util.LinkedHashMap;

public class Rules extends LinkedHashMap<String, RulesConfig> {
 
	private static final long serialVersionUID = 1L;

	public void add(RulesConfig config) {
		super.put(config.getRepositoryId()+":"+config.getRuleName(),config);
		
	}
}
