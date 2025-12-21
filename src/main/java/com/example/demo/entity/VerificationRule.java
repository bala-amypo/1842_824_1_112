package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class VerificationRule{
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, nullable=false)
    private String ruleCode;
    private String description;
    private String appliesToType;
    private String validationExpression;
    private Boolean active=true;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public String getRuleCode(){
        return ruleCode;
    }
    public void setRuleCode(String ruleCode){
        this.ruleCode=ruleCode;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public String getAppliesToType(){
        return appliesToType;
    }
    public void setAppliesToType(String appliesToType){
        this.appliesToType=appliesToType;
    }

    public String getValidationExpression(){
        return validationExpression;
    }
    public void setValidationExpression(String validationExpression){
        this.validationExpression=validationExpression;
    }

    public Boolean getActive(){
        return active;
    }
    public void setActive(Boolean active){
        this.active=active;
    }

    public VerificationRule(Long id, String ruleCode, String description, String appliesToType, String validationExpression, Boolean active){
        this.id=id;
        this.ruleCode=ruleCode;
        this.description=description;
        this.appliesToType=appliesToType;
        this.validationExpression=validationExpression;
        this.active=active;
    }

    public VerificationRule(){
    }
}