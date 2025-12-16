package com.example.demo.entity;

import java.time.LocalDateTime;
public class VerificationRequest{
    
    private Long id;
    private Long credentialId;
    private String requestBy;
    private String ver;
    private String organization;
    private Boolean active;
    private LocalDateTime createdAt;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getHolderId(){
        return holderId;
    }
    public void setHolderId(String holderId){
        this.holderId=holderId;
    }

    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName=fullName;
    }

    public String getEmail(){
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