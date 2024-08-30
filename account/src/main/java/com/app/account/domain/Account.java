package com.app.account.domain;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
  private String id;
  private Long accountNumber;
  private String accountHolderName;
  private String ifscCode;
  private AccountType type;
  private boolean isActive;
  private BigDecimal balance;
}