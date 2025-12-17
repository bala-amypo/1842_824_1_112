package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CredentialHolderProfile;
import java.util.Long;

@Repository
public interface CredentialHolderProfile extends JpaRepository<CredentialHolderProfile, Long>{

}
