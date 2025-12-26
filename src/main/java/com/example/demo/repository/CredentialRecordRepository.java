// // package com.example.demo.repository;

// // import com.example.demo.entity.CredentialRecord;
// // import org.springframework.data.jpa.repository.JpaRepository;
// // import org.springframework.data.jpa.repository.Query;
// // import org.springframework.data.repository.query.Param;

// // import java.time.LocalDateTime;
// // import java.util.List;

// // public interface CredentialRecordRepository extends JpaRepository<CredentialRecord, Long> {

// //     List<CredentialRecord> findByHolderId(Long holderId);

// //     CredentialRecord findByCredentialCode(String code);

// //     List<CredentialRecord> findByExpiryDateBefore(LocalDateTime date);

// //     @Query("SELECT c FROM CredentialRecord c WHERE c.status = :status")
// //     List<CredentialRecord> findByStatusUsingHql(@Param("status") String status);

// //     @Query("SELECT c FROM CredentialRecord c WHERE c.issuer = :issuer AND c.credentialType = :type")
// //     List<CredentialRecord> searchByIssuerAndType(@Param("issuer") String issuer, @Param("type") String type);
// // }




// package com.example.demo.repository;

// import com.example.demo.entity.CredentialRecord;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import java.time.LocalDate;
// import java.util.List;
// import java.util.Optional;

// public interface CredentialRecordRepository extends JpaRepository<CredentialRecord, Long> {
//     List<CredentialRecord> findByHolderId(Long holderId);
//     Optional<CredentialRecord> findByCredentialCode(String credentialCode);

//     @Query("SELECT c FROM CredentialRecord c WHERE c.expiryDate < ?1")
//     List<CredentialRecord> findExpiredBefore(LocalDate date);

//     @Query("SELECT c FROM CredentialRecord c WHERE c.status = ?1")
//     List<CredentialRecord> findByStatusUsingHql(String status);

//     @Query("SELECT c FROM CredentialRecord c WHERE c.issuer = ?1 AND c.credentialType = ?2")
//     List<CredentialRecord> searchByIssuerAndType(String issuer, String credentialType);
// }

package com.example.demo.repository;
import com.example.demo.entity.CredentialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.*;

public interface CredentialRecordRepository extends JpaRepository<CredentialRecord, Long> {
    List<CredentialRecord> findByHolderId(Long holderId);
    Optional<CredentialRecord> findByCredentialCode(String code);

    @Query("SELECT c FROM CredentialRecord c WHERE c.expiryDate < :date")
    List<CredentialRecord> findExpiredBefore(LocalDate date);

    @Query("SELECT c FROM CredentialRecord c WHERE c.status = :status")
    List<CredentialRecord> findByStatusUsingHql(String status);

    @Query("SELECT c FROM CredentialRecord c WHERE c.issuer = :issuer AND c.credentialType = :type")
    List<CredentialRecord> searchByIssuerAndType(String issuer, String type);
}