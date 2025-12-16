package com.example.demo.entity;

import java.time.LocalDateTime;
public class VerificationRequest{
    
    private Long id;
    private Long credentialId;
    private String requestBy;
    private String verificationMethod;
    private String status;
    private LocalDateTime verifiedAt;
    private String resultMessage;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getCredentialId(){
        return credentialId;
    }
    public void setCredentialId(String credentialId){
        this.credentialId=credentialId;
    }

    public String getRequestBy(){
        return requestBy;
    }
    public void setRequestBy(String requestBy){
        this.requestBy=requestBy;
    }

    public String getVerificationMethod(){
        return verificationMethod;
    }
    public void setVerificationMethod(String verificationMethod){
        this.verificationMethod=verificationMethod;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String organization){
        this.organization=organization;
    }

    public Boolean getActive(){
        return active;
    }
    public void setActive(Boolean active){
        this.active=active;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime creatAt){
        this.createdAt=createdAt;
    }
}