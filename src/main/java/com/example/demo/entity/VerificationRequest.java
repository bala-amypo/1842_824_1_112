// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.PrePersist;
// import java.time.LocalDateTime;

// @Entity
// public class VerificationRequest{
//     @Id
//     @GeneratedValue (strategy=GenerationType.IDENTITY)
//     private Long id;
//     private Long credentialId;
//     private String requestBy;
//     private String verificationMethod;
//     private String status;
//     private LocalDateTime verifiedAt;
//     private String resultMessage;

//     @PrePersist
//     public void onCreate() {
//         this.status = "PENDING";
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

//     public String getRequestBy(){
//         return requestBy;
//     }
//     public void setRequestBy(String requestBy){
//         this.requestBy=requestBy;
//     }

//     public String getVerificationMethod(){
//         return verificationMethod;
//     }
//     public void setVerificationMethod(String verificationMethod){
//         this.verificationMethod=verificationMethod;
//     }

//     public String getStatus(){
//         return status;
//     }
//     public void setStatus(String status){
//         this.status=status;
//     }

//     public LocalDateTime getVerifiedAt(){
//         return verifiedAt;
//     }
//     public void setVerifiedAt(LocalDateTime verifiedAt){
//         this.verifiedAt=verifiedAt;
//     }

//     public String getResultMessage(){
//         return resultMessage;
//     }
//     public void setResultMessage(String resultMessage){
//         this.resultMessage=resultMessage;
//     }

//     public VerificationRequest(Long id, Long credentialId, String requestBy, String verificationMethod, String status, LocalDateTime verifiedAt, String resultMessage){
//         this.id=id;
//         this.credentialId=credentialId;
//         this.requestBy=requestBy;
//         this.verificationMethod=verificationMethod;
//         this.status=status;
//         this.verifiedAt=verifiedAt;
//         this.resultMessage=resultMessage;
//     }

//     public VerificationRequest(){
//     }
// }

package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
public class VerificationRequest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long credentialId;
    private String status;
}