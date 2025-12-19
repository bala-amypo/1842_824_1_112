package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.example.demo.entity.VerificationRule;
import com.example.demo.service.VerificationRuleService;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class VerificationRuleController {

    @Autowired
    private VerificationRuleService vrs;

    @PostMapping
    public VerificationRule createRule(@RequestBody VerificationRule rule) {
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
}
