package com.example.demo.service.impls;

import com.example.demo.service.VerificationRuleService;
import com.example.demo.repository.VerificationRuleRepository;
import com.example.demo.entity.VerificationRule;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class VerificationRuleImpls implements VerificationRuleService {

    @Autowired
    private VerificationRuleRepository vrr;

    @Override
    public VerificationRule createRule(VerificationRule rule) {
        if (record.getStatus() == null) {
            record.setStatus("VALID");
        }
        return vrr.save(rule);
    }

    @Override
    public VerificationRule updateRule(Long id, VerificationRule updatedRule) {
        VerificationRule existing = vrr.findById(id).orElseThrow(() ->new RuntimeException("Credential not found"));

        existing.setCredentialCode(updated.getCredentialCode());
        existing.setHolderId(updated.getHolderId());
        existing.setStatus(updated.getStatus());

        return vrr.save(existing);
    }

    @Override
    public List<VerificationRule> getActiverules() {
        return vrr.findByActiverules();
    }

    @Override
    public List<VerificationRule> getAllRules() {
        return vrr.findAll();
    }
}
