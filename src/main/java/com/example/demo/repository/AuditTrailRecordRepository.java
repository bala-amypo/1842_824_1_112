// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.demo.entity.AuditTrailRecord;
// import java.util.List;
// import java.lang.Long;

// @Repository
// public interface AuditTrailRecordRepository extends JpaRepository<AuditTrailRecord, Long>{
//     List<AuditTrailRecord> findByCredentialId(Long credentialId);
// }


package com.example.demo.repository;

import com.example.demo.entity.AuditTrailRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuditTrailRecordRepository extends JpaRepository<AuditTrailRecord, Long> {
    List<AuditTrailRecord> findByCredentialId(Long credentialId);
}