// package com.example.demo.service.impls;

// import com.example.demo.service.VerificationRequestService;
// import com.example.demo.repository.VerificationRequestRepository;
// import com.example.demo.repository.CredentialRecordRepository;
// import com.example.demo.repository.VerificationRuleRepository;
// import com.example.demo.entity.VerificationRequest;
// import com.example.demo.entity.CredentialRecord;
// import com.example.demo.exception.ResourceNotFoundException;

// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;

// import java.util.List;
// import java.time.LocalDateTime;

// @Service
// public class VerificationRequestServiceImpl implements VerificationRequestService {

//     @Autowired
//     private VerificationRequestRepository vrr;

//     @Autowired
//     private CredentialRecordRepository credentialRepo;

//     @Autowired
//     private VerificationRuleRepository ruleRepo;

//     @Override
//     public VerificationRequest initiateVerification(VerificationRequest request) {
//         request.setStatus("PENDING");
//         return vrr.save(request);
//     }

//     @Override
//     public VerificationRequest processVerification(Long requestId) {

//         VerificationRequest req = vrr.findById(requestId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Request not found"));

//         CredentialRecord cred = credentialRepo.findById(req.getCredentialId())
//                 .orElseThrow(() -> new ResourceNotFoundException("Credential missing"));

//         // Load active rules (if needed)
//         ruleRepo.findByActiveTrue();

//         // Expiry Check
//         if (cred.getExpiryDate() != null &&
//                 cred.getExpiryDate().isBefore(LocalDateTime.now())) {

//             req.setStatus("FAILED");
//         } else {
//             req.setStatus("SUCCESS");
//         }

//         req.setVerifiedAt(LocalDateTime.now());
//         return vrr.save(req);
//     }

//     @Override
//     public List<VerificationRequest> getRequestsByCredential(Long credentialId) {
//         return vrr.findByCredentialId(credentialId);
//     }

//     @Override
//     public List<VerificationRequest> getAllRequests() {
//         return vrr.findAll();
//     }
// }

package com.example.demo.service.impls;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.VerificationRequest;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.service.VerificationRequestService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VerificationRequestServiceImpl implements VerificationRequestService {

    private final VerificationRequestRepository repository;

    @Override
    public List<VerificationRequest> getAllRequests() {
        return repository.findAll();
    }
}
