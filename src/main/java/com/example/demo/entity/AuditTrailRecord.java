package com.example.demo.entity;

import java.time.LocalDateTime;
public class AuditTrailRecord{
    
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
    public void setCredentialId(String credentialId){
        this.credentialId=credentialId;

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
}