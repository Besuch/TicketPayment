package com.ticket24.payment.entity;

import com.ticket24.payment.enums.ClaimStatusType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Claim {
    @Id
    @GeneratedValue
    private Long number;
    private ClaimStatusType statusType;

    public Claim() {
    }

    public Claim(Long number, ClaimStatusType statusType) {
        this.number = number;
        this.statusType = statusType;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public ClaimStatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(ClaimStatusType statusType) {
        this.statusType = statusType;
    }
}
