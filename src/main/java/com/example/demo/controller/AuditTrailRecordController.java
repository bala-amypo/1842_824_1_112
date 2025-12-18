package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.service.AuditTrailRecordService;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditTrailRecordController {

    @Autowired
    AuditTrailRecordService atrs;

    @PostMapping
    public AuditTrailRecord addAuditTrailRecord(@RequestBody AuditTrailRecord atr) {
        return atrs.logEvent(atr);
    }
    @GetMapping("/credential/{credentialId}")
    public List<AuditTrailRecord> getByCredential(@PathVariable Long credentialId) {
        return atrs.getLogsByCredential(credentialId);
    }

    @GetMapping("/all")
    public List<AuditTrailRecord> getAll() {
        return atrs.getAllLogs();
    }
}