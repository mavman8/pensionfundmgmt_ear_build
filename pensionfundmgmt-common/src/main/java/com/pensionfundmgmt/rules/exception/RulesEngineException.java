package com.pensionfundmgmt.rules.exception;

public class RulesEngineException extends Throwable{

	private static final long serialVersionUID = 1L;

	public RulesEngineException(String message){
    	super(message);
    }
	
	public RulesEngineException(String message, Throwable t){
    	super(message, t);
    }
}