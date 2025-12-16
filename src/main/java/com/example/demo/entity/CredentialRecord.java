package com.example.demo.entity;

import java.time.LocalDateTime;
public class CredentialRecord{
    
    private Long id;
    private String holderId;
    private String credentialCode;
    private String title;
    private String issuer;
    private LocalDateTime issueDate;
    private LocalDateTime expiryDate;
    private String credentialType;
    private String status;
    private String  metadataJson;