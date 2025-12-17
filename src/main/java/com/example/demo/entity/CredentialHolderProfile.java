package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
public class CredentialHolderProfile{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;
    private String holderId;
    private String fullName;
    private String email;
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

    public CredentialHolderProfile(Long id, Long holderId;
    private String fullName;
    private String email;
    private String organization;
    private Boolean active;
    private LocalDateTime createdAt;){
        this.id=id;
        this.credentialId=credentialId;
        this.eventType=eventType;
        this.details=details;
        this.loggedAt=loggedAt;
    }
}