// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.Column;
// import java.time.LocalDateTime;
// import java.util.List;


// @Entity
// public class AuditTrailRecord{

//     @Id
//     @GeneratedValue(strategy=GenerationType.IDENTITY)
//     private Long id;
//     private Long credentialId;
//     private String eventType;
//     @Column(columnDefinition = "TEXT")
//     private String details;
//     private LocalDateTime loggedAt;

//     @PrePersist
//     public void onLog() {
//         this.loggedAt = LocalDateTime.now();
//     }

//     public Long getId(){
//         return id;
//     }
//     public void setId(Long id){
//         this.id=id;
//     }

//     public Long getCredentialId(){
//         return credentialId;
//     }
//     public void setCredentialId(Long credentialId){
//         this.credentialId=credentialId;
//     }

//     public String getEventType(){
//         return eventType;
//     }
//     public void setEventType(String eventType){
//         this.eventType=eventType;
//     }

//     public String getDetails(){
//         return details;
//     }
//     public void setDetails(String details){
//         this.details=details;
//     }

//     public LocalDateTime getLoggedAt(){
//         return loggedAt;
//     }
    

//     public AuditTrailRecord(Long id, Long credentialId, String eventType ,String details ,LocalDateTime loggedAt){
//         this.id=id;
//         this.credentialId=credentialId;
//         this.eventType=eventType;
//         this.details=details;
//         this.loggedAt=loggedAt;
//     }

//     public AuditTrailRecord(){
//     }
// }


package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity @Data
public class AuditTrailRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long credentialId;
    private LocalDateTime loggedAt;
}