package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.service.AuditTrailRecordService;

@RestController
public class AuditTrailRecordController {
    private final AuditTrailRecordService auditTrailRecordService;

    public AuditTrailRecordController(AuditTrailRecordService auditTrailRecordService){
        this.auditTrailRecordService=auditTrailRecordService;
    }
    
}
