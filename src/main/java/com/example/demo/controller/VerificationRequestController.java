package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.example.demo.entity.VerificationRequest;
import com.example.demo.service.VerificationRequestService;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class VerificationRequestController {

    @Autowired
    private VerificationRequestService vrss;

    @PostMapping
    public VerificationRule (@RequestBody VerificationRule rule) {
        return vrs.createRule(rule);
    }

    @PutMapping("/{id}")
    public VerificationRule updateRule( @PathVariable Long id,@RequestBody VerificationRule rule) {
        return vrs.updateRule(id, rule);
    }

    @GetMapping("/active")
    public List<VerificationRule> getActiveRules() {
        return vrs.getActiveRules();
    }

    @GetMapping
    public List<VerificationRule> getAllRules() {
        return vrs.getAllRules();
    }
    @GetMapping
    public List<VerificationRule> getAllRules() {
        return vrs.getAllRules();
    }
}
