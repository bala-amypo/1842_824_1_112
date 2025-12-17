package com.example.collectiondb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuditTrailRecordController;
import com.example.demo.service.studentService;


@RestController
public class studentController {
    
    @Autowired
    studentService stuser;

    @PostMapping("/path")
    public studentEntity studatas(@RequestBody studentEntity student) {
        return stuser.saveData(student);
    }
    
}
