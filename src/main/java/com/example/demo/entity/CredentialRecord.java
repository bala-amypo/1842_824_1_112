package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import java.util.List;

@Entity
public class CredentialRecord{
    
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;
    private Long holderId;
    @Column(unique=true, nullable=false)
    private String credentialCode;
    private String title;
    private String issuer;
    private LocalDateTime issueDate;
    private LocalDateTime expiryDate;
    private String credentialType;
    private String status;
    @Column(columnDefinition = "TEXT")
    private String  metadataJson;

    @ManyToMany
    @JoinTable(
        name = "credential_verification_rules",
        joinColumns = @JoinColumn(name = "credential_id"),
        inverseJoinColumns = @JoinColumn(name = "rule_id")
    )

    private List<VerificationRule> rules;

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

    public String getMetaDataJson(){
        return metadataJson;
    }
    public void setMetaDataJson(String metadataJson){
        this.metadataJson=metadataJson;
    }

    public List<VerificationRule> getRules(){
        return rules; 
    }
    public void setRules(List<VerificationRule> rules){
        this.rules = rules; 
    }

    public CredentialRecord(Long id , Long holderId, String credentialCode ,String title, String issuer, LocalDateTime issueDate, LocalDateTime expiryDate, String credentialType, String status, String  metadataJson){
        this.id=id;
        this.holderId=holderId;
        this.credentialCode=credentialCode;
        this.title=title;
        this.issuer=issuer;
        this.issueDate=issueDate;
        this.expiryDate=expiryDate;
        this.credentialType=credentialType;
        this.status=status;
        this.metadataJson=metadataJson;
    }

    public CredentialRecord(){
    }
} 