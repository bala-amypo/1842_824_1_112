// package com.example.demo.service.impls;

// import com.example.demo.service.VerificationRuleService;
// import com.example.demo.repository.VerificationRuleRepository;
// import com.example.demo.entity.VerificationRule;

// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;

// import java.util.List;

// @Service
// public class VerificationRuleServiceImpl implements VerificationRuleService {

//     @Autowired
//     private VerificationRuleRepository vrr;

//     @Override
//     public VerificationRule createRule(VerificationRule rule) {
//         if (rule.getActive() == null) {
//             rule.setActive(true);
//         }
//         return vrr.save(rule);
//     }

//     @Override
//     public VerificationRule updateRule(Long id, VerificationRule updatedRule) {
//         VerificationRule existing = vrr.findById(id).orElseThrow(() -> new RuntimeException("VerificationRule not found"));

//         existing.setRuleCode(updatedRule.getRuleCode());
//         existing.setDescription(updatedRule.getDescription());
//         existing.setAppliesToType(updatedRule.getAppliesToType());
//         existing.setValidationExpression(updatedRule.getValidationExpression());
//         existing.setActive(updatedRule.getActive());

//         return vrr.save(existing);
//     }

//     @Override
//     public List<VerificationRule> getActiveRules() {
//         return vrr.findByActiveTrue();
//     }

//     @Override
//     public List<VerificationRule> getAllRules() {
//         return vrr.findAll();
//     }
// }

package com.example.demo.service.impls;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.VerificationRule;
import com.example.demo.repository.VerificationRuleRepository;
import com.example.demo.service.VerificationRuleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VerificationRuleServiceImpl implements VerificationRuleService {

    private final VerificationRuleRepository repository;

    @Override
    public VerificationRule updateRule(Long id, VerificationRule rule) {
        rule.setId(id);
        return repository.save(rule);
    }

    @Override
    public List<VerificationRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
    public List<VerificationRule> getAllRules() {
        return repository.findAll();
    }
}
