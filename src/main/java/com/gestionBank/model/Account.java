package com.gestionBank.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.UUID;

public class Account {
    private String accountId;
    private UUID ownerUserId;
    private BigDecimal balance;
    private Instant createdAt;
    private boolean active;

    public Account() {
        this.balance = BigDecimal.ZERO.setScale(2);
        this.createdAt = Instant.now();
        this.active = true;
    }

    public Account(String accountId, UUID ownerUserId) {
        this();
        this.accountId = accountId;
        this.ownerUserId = ownerUserId;
    }

    //Getter && Setter
    public String getAccountId(){
        return accountId;
    }

    public void setAccountId(String accountId){
        this.accountId = accountId;
    }

    public UUID getOwnerUserId(){
        return ownerUserId;
    }

    public void setOwnerUserId(UUID ownerUserId){
        this.ownerUserId = ownerUserId;
    }

    public BigDecimal getBalance(){
        return balance;
    }
    public void setBalance(BigDecimal balance){
        this.balance = balance.setScale(2);
    }

    public Instant getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt){
        this.createdAt = createdAt;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

}
