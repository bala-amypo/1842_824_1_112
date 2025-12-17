package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example..entity.studentEntity;

@Repository
public interface AuditTrailRecordRepository extends JpaRepository<studentEntity, Long>{

}
