package com.example.demo.service.impls;

import com.example.demo.service.AuditTrailRecordService;
import com.example.demo.repository.AuditTrailRecordRepository;
import com.example.demo.entity.AuditTrailRecord;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class AuditTrailRecordImpls {
    
    @Autowired
    AuditTrailRecordRepository atrr;

    public AuditTrailRecord logEvent(AuditTrailRecord record){
        return atrr.save(record);
    }

    public Long getLogsByCredential(Long credentialId){
        return atrr.findById(credentialId);
    }

    public List<AuditTrailRecord> getAllLogs(){
        return atrr.findAll();
    }
}