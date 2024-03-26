package com.pensionfundmgmt.aggregate.request;

public class HoldingsInfoRequest {

	public String viewExitRequestForSchemeName;

	public ViewTransactionDateRange viewTransactionDateRange;

	public String getViewExitRequestForSchemeName() {
		return viewExitRequestForSchemeName;
	}

	public void setViewExitRequestForSchemeName(String viewExitRequestForSchemeName) {
		this.viewExitRequestForSchemeName = viewExitRequestForSchemeName;
	}

	public ViewTransactionDateRange getViewTransactionDateRange() {
		return viewTransactionDateRange;
	}

	public void setViewTransactionDateRange(ViewTransactionDateRange viewTransactionDateRange) {
		this.viewTransactionDateRange = viewTransactionDateRange;
	}
}
