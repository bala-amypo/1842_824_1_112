package com.example.demo.entity;

public class CredentialHolderProfile{
    
    private Long id;
    private String holderId;
    private String fullName;
    private String email;
    private String organization;
    private Boolean active;
    private LocalDateTime creatAt;

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
    public void setId(String email){
        this.email=email;
    }

    public String getId(){
        return organization;
    }
    public void setId(String organization){
        this.organization=organization;
    }

    public Boolean getId(){
        return active;
    }
    public void setId(Boolean active){
        this.active=active;
    }

    public LocalDateTime getId(){
        return creatAt;
    }
    public void setId(LocalDateTime creatAt){
        this.creatAt=creatAt;
    }
}