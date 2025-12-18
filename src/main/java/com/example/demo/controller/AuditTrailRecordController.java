package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.service.AuditTrailRecordService;
import java.util.List;

@RestController
public class AuditTrailRecordController {
    @Autowired
    AuditTrailRecordService atrs;

    @PostMapping("/AuditTrail")
    public AuditTrailRecord addAuditTrailRecord(@RequestBody AuditTrailRecord atr){
        return atrs.logEvent(atr);
    }

    @GetMapping("/")
    public Long first(Long credentialId){
        return atrs.getLogs();
    }

    @GetMapping
    public List<AuditTrailRecord> second(){
        return atrs.getAllLogs();
    }
}
