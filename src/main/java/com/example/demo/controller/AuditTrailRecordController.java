package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.service.AuditTrailRecordService;

@RestController
public class AuditTrailRecordController {
    @Autowired
    AuditTrailRecordService atrs;

    @PostMapping("/AuditTrail")
    public AuditTrailRecord addAuditTrailRecord(@RequestBody AuditTrailRecord atr){
        return atrs.createAuditTrailRecord(atr);
    }

    @GetMapping
    public int getLogsByCredential(Long credentialId){
        return atrs.
    }

    @GetMapping
    public List<AuditTrailRecord> getAllLogs(){
        return atrs.getAllLogsAuditTrailRecord();
    }
}
