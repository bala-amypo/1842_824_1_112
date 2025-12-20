package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
public class CredentialHolderProfile{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String holderId;
    private String fullName;
    @Column(unique=true)
    private String email;
    private String organization;
    @Column(nullable=false)
    private Boolean active=true;
    @Column(updatable=false)
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
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }

    public CredentialHolderProfile(Long id, String holderId, String fullName, String email, String organization, Boolean active, LocalDateTime createdAt){
        this.id=id;
        this.holderId=holderId;
        this.fullName=fullName;
        this.email=email;
        this.organization=organization;
        this.active=active;
        this.createdAt=createdAt;
    }
    public CredentialHolderProfile(){
    }
}