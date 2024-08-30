package com.app.account.entity;

import com.app.account.domain.AccountType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "Account")
public class AccountEntity {

  @Id
  @Column(name = "id", nullable = false, unique = true)
  private String id;

  @Column(name = "accountNumber", nullable = false, unique = true)
  private Long accountNumber;

  @Column(name = "holderName", nullable = false)
  private String accountHolderName;

  @Column(name = "ifscCode", nullable = false)
  private String ifscCode;

  @Column(name = "type", nullable = false)
  @Enumerated(EnumType.STRING)
  private AccountType type;

  @Column(name = "isActive", nullable = false)
  private boolean isActive;

  @Column(name = "balance", nullable = false)
  private BigDecimal balance;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Long getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(Long accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountHolderName() {
    return accountHolderName;
  }

  public void setAccountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
  }

  public AccountType getType() {
    return type;
  }

  public void setType(AccountType type) {
    this.type = type;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public String getIfscCode() {
    return ifscCode;
  }

  public void setIfscCode(String ifscCode) {
    this.ifscCode = ifscCode;
  }
}
