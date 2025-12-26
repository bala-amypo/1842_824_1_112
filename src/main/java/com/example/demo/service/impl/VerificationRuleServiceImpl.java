package com.example.demo.service.impl;

import com.example.demo.entity.VerificationRule;
import com.example.demo.repository.VerificationRuleRepository;
import com.example.demo.service.VerificationRuleService;
import org.springframework.stereotype.Service;

@Service
public class VerificationRuleServiceImpl implements VerificationRuleService {

    private final VerificationRuleRepository ruleRepo;

    public VerificationRuleServiceImpl(VerificationRuleRepository ruleRepo) {
        this.ruleRepo = ruleRepo;
    }

    @Override
    public VerificationRule createRule(VerificationRule rule) {
        // PDF Rule: createRule must save the rule with ruleRepo.save(rule) and return it.
        return ruleRepo.save(rule);
    }
}