package com.pensionfundmgmt.personalinfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pensionfundmgmt.aggregate.request.AggregateRequest;
import com.pensionfundmgmt.personalinfo.model.PersonalInfo;

@Repository
public interface PersonalInfoDao extends JpaRepository<PersonalInfo, Integer>{
}
