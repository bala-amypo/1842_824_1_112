package com.example.demo.service.impls;

import com.example.demo.service.CredentialHolderProfileService;
import com.example.demo.repository.CredentialHolderProfileRepository;
import com.example.demo.entity.CredentialHolderProfile;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class AuditTrailRecordImpls implements AuditTrailRecordService{
    
    @Autowired
    private CredentialHolderProfileRepository chpr;

    @Override
    public CredentialHolderProfile createHolder(CredentialHolderProfile profile){
        return chpr.save(profile);
    }

    @Override
    public CredentialHolderProfile getHolderById(Long Id){
        return atrr.findByCredentialId(Id);
    }

    @Override
    public List<AuditTrailRecord> getAllLogs(){
        return atrr.findAll();
    }
}