package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

@Entity
public class CredentialRecord{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
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
    public void setHolderId(Long holderId){
        this.holderId=holderId;
    }

    public String getCredentialCode(){
        return credentialCode;
    }
    public void setCredentialCode(String credentialCode){
        this.credentialCode=credentialCode;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }

    public String getIssuer(){
        return issuer;
    }
    public void setIssuer(String issuer){
        this.issuer=issuer;
    }

    public LocalDateTime getIssueDate(){
        return issueDate;
    }
    public void setIssueDate(LocalDateTime issueDate){
        this.issueDate=issueDate;
    }

    public LocalDateTime getExpiryDate(){
        return expiryDate;
    }
    public void setExpiryDate(LocalDateTime expiryDate){
        this.expiryDate=expiryDate;
    }

    public String getCredentialType(){
        return credentialType;
    }
    public void setCredentialType(String credentialType){
        this.credentialType=credentialType;
    }
    
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }

    public String getCredentialCode(){
        return credentialCode;
    }
    public void setMetaDataJson(String metadataJson){
        this.metadataJson=metadataJson;
    }
} 