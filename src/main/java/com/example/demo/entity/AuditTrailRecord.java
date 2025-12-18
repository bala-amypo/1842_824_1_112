package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
import java.time.Long;

@Entity
public class AuditTrailRecord{

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;
    private Long credentialId;
    private String eventType;
    private String details;
    private LocalDateTime loggedAt;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public Long getCredentialId(){
        return credentialId;
    }
    public void setCredentialId(Long credentialId){
        this.credentialId=credentialId;
    }

    public String getEventType(){
        return eventType;
    }
    public void setEventType(String eventType){
        this.eventType=eventType;
    }

    public String getDetails(){
        return details;
    }
    public void setDetails(String details){
        this.details=details;
    }

    public LocalDateTime getLoggedAt(){
        return loggedAt;
    }
    public void setLoggedAt(LocalDateTime loggedAt){
        this.loggedAt=loggedAt;
    }

    public AuditTrailRecord(Long id, Long credentialId, String eventType ,String details ,LocalDateTime loggedAt){
        this.id=id;
        this.credentialId=credentialId;
        this.eventType=eventType;
        this.details=details;
        this.loggedAt=loggedAt;
    }

    public AuditTrailRecord(){
    }
}