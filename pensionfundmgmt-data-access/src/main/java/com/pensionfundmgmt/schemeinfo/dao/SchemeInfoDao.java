package com.pensionfundmgmt.schemeinfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pensionfundmgmt.schemainfo.model.SchemeInfo;

@Repository
public interface SchemeInfoDao extends JpaRepository<SchemeInfo, Integer>{
}
