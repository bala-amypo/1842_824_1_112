// package com.example.demo.service.impls;

// import com.example.demo.service.AuditTrailRecordService;
// import com.example.demo.repository.AuditTrailRecordRepository;
// import com.example.demo.entity.AuditTrailRecord;
// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;
// import java.util.List;

// @Service
// public class AuditTrailRecordServiceImpl implements AuditTrailRecordService{
    
//     @Autowired
//     private AuditTrailRecordRepository atrr;

//     @Override
//     public AuditTrailRecord logEvent(AuditTrailRecord record){
//         return atrr.save(record);
//     }

//     @Override
//     public List<AuditTrailRecord> getLogsByCredential(Long credentialId){
//         return atrr.findByCredentialId(credentialId);
//     }

//     @Override
//     public List<AuditTrailRecord> getAllLogs(){
//         return atrr.findAll();
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.repository.AuditTrailRecordRepository;
import com.example.demo.service.AuditTrailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service @RequiredArgsConstructor
public class AuditTrailServiceImpl implements AuditTrailService {
    private final AuditTrailRecordRepository auditRepo;

    public AuditTrailRecord logEvent(AuditTrailRecord record) {
        if (record.getLoggedAt() == null) record.setLoggedAt(LocalDateTime.now());
        return auditRepo.save(record);
    }

    public List<AuditTrailRecord> getLogsByCredential(Long id) { return auditRepo.findByCredentialId(id); }
}