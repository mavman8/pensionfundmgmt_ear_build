package com.pensionfundmgmt.aggregate.request;

public class AggregateRequest {
	private int uniqueId;

	private String requestType;

	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	private HoldingsInfoRequest holdingsInfoRequest;

	public HoldingsInfoRequest getHoldingsInfoRequest() {
		return holdingsInfoRequest;
	}

	public void setHoldingsInfoRequest(HoldingsInfoRequest holdingsInfoRequest) {
		this.holdingsInfoRequest = holdingsInfoRequest;
	}

}