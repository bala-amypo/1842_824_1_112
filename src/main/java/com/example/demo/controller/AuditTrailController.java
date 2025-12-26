package com.example.demo.controller;

import com.example.demo.entity.AuditTrailRecord;
import com.example.demo.service.AuditTrailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditTrailController {
    private final AuditTrailService atrs;

    public AuditTrailController(AuditTrailService atrs) {
        this.atrs = atrs;
    }

    @PostMapping
    public ResponseEntity<AuditTrailRecord> log(@RequestBody AuditTrailRecord record) {
        return ResponseEntity.ok(atrs.logEvent(record));
    }

    @GetMapping("/credential/{credentialId}")
    public ResponseEntity<List<AuditTrailRecord>> getByCredential(@PathVariable Long credentialId) {
        return ResponseEntity.ok(atrs.getLogsByCredential(credentialId));
    }
}