package com.example.demo.service.impls;

import com.example.demo.service.VerificationRequestService;
import com.example.demo.repository.VerificationRequestRepository;
import com.example.demo.entity.VerificationRequest;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class VerificationRequestImpls implements VerificationRequestervice {

    @Autowired
    private VerificationRequestRepository vrr;

    @Override
    public VerificationRequest initiateVerification(VerificationRequest request){
        return vrr.save(request);
    }

    @Override
    public VerificationRequest processVerification(Long requestId){
        return vrr.save(request);
    }

    @Override
    public List<VerificationRequest> getActiverules() {
        return vrr.findByActiverules();
    }

    @Override
    public List<VerificationRequest> getAllRules() {
        return crr.findById();
    }
}