package com.pensionfundmgmt.bankinfo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BankInfo")
public class BankInfo {
	public int getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankBranch() {
		return BankBranch;
	}

	public void setBankBranch(String bankBranch) {
		BankBranch = bankBranch;
	}

	public String getBankName() {
		return BankName;
	}

	public void setBankName(String bankName) {
		BankName = bankName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getIfscCode() {
		return IfscCode;
	}

	public void setIfscCode(String ifscCode) {
		IfscCode = ifscCode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uniqueId;

	private int accountNumber;

	private String BankBranch;

	private String BankName;

	private String Address;

	private String IfscCode;

}