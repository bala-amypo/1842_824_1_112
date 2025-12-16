package com.example.collectiondb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.collectiondb.entity.studentEntity;

@Repository
public interface stuRepo extends JpaRepository<studentEntity, Long>{

}
