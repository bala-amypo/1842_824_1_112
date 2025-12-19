package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.service.AuditTrailRecordService;
import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditTrailRecordController {
    @Autowired
    private AuditTrailRecordService atrs;

    @PostMapping
    public AuditTrailRecord addAuditTrailRecord(@RequestBody AuditTrailRecord atr){
        return atrs.logEvent(atr);
    }

    @GetMapping("/{credentialId}")
    public List<AuditTrailRecord> getByCredential(@PathVariable Long credentialId){
        return atrs.getLogsByCredential(credentialId);
    }

    @GetMapping
    public List<AuditTrailRecord> getAll(){
        return atrs.getAllLogs();
    }
}