package com.example.collectiondb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.service.AuditTrailRecordService;


@RestController
public class AuditTrailRecordController {
    
    @Autowired
    AuditTrailRecordService stuser;

    @PostMapping("/")
    public studentEntity studatas(@RequestBody studentEntity student) {
        return stuser.saveData(student);
    }
    
}
