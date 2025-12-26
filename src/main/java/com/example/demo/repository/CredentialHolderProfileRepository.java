package com.example.demo.repository;
import com.example.demo.entity.CredentialHolderProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CredentialHolderProfileRepository extends JpaRepository<CredentialHolderProfile, Long> {
    // Corrected method name to match JPA standards and PDF rules
    Optional<CredentialHolderProfile> findById(Long id);
}