package com.example.demo.entity;

import java.time.LocalDateTime;
public class CredentialRecord{
    
    private Long id;
    private Long holderId;
    private String credentialCode;
    private String title;
    private String issuer;
    private LocalDateTime issueDate;
    private LocalDateTime expiryDate;
    private String credentialType;
    private String status;
    private String  metadataJson;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public Long getHolderId(){
        return holderId;
    }
    public void setHolderId(String holderId){
        this.holderId=holderId;
    }

    public String getCredentialCode(){
        return fullName;
    }
    public void setCredentialCode(String fullName){
        this.fullName=fullName;
    }

    public String getTitle(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public String getOrganization(){
        return organization;
    }
    public void setOrganization(String organization){
        this.organization=organization;
    }

    public Boolean getActive(){
        return active;
    }
    public void setActive(Booleanctive){
        this.active=active;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime creatAt){
        this.createdAt=createdAt;
    }
} 