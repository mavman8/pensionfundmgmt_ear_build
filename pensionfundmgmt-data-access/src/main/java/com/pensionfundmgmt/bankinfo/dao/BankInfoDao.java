package com.pensionfundmgmt.bankinfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pensionfundmgmt.bankinfo.model.BankInfo;

@Repository
public interface BankInfoDao extends JpaRepository<BankInfo, Integer>{
}
