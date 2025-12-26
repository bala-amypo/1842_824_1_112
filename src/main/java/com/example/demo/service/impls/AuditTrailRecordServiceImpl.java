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

package com.example.demo.service.impls;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.repository.AuditTrailRecordRepository;
import com.example.demo.service.AuditTrailRecordService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditTrailRecordServiceImpl implements AuditTrailRecordService {

    private final AuditTrailRecordRepository repository;

    @Override
    public List<AuditTrailRecord> getAllLogs() {
        return repository.findAll();
    }
}
