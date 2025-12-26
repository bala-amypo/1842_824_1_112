// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.demo.entity.CredentialHolderProfile;

// @Repository
// public interface CredentialHolderProfileRepository extends JpaRepository<CredentialHolderProfile, Long>{
//     CredentialHolderProfile findByHolderId(String holderId);
// }

package com.example.demo.repository;

import com.example.demo.entity.CredentialHolderProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CredentialHolderProfileRepository extends JpaRepository<CredentialHolderProfile, Long> {
    // Standard findById and save are inherited from JpaRepository
}

