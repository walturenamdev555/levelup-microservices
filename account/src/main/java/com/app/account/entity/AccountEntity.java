package com.app.account.entity;

import com.app.account.domain.AccountType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Account")
public class AccountEntity {

  @Id
  @Column(name = "accountId", nullable = false, unique = true)
  private String accountId;

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

  @Column(name = "accountOpenDate", nullable = false)
  private LocalDateTime accountOpenDate;

  @Column(name = "accountClosedDate")
  private LocalDate accountClosedDate;

  @Column(name = "balance", nullable = false)
  private BigDecimal balance;

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
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

  public LocalDateTime getAccountOpenDate() {
    return accountOpenDate;
  }

  public void setAccountOpenDate(LocalDateTime accountOpenDate) {
    this.accountOpenDate = accountOpenDate;
  }

  public LocalDate getAccountClosedDate() {
    return accountClosedDate;
  }

  public void setAccountClosedDate(LocalDate accountClosedDate) {
    this.accountClosedDate = accountClosedDate;
  }
}
