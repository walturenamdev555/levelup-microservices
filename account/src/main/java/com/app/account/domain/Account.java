package com.app.account.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
  private String accountId;
  private Long accountNumber;
  private String accountHolderName;
  private String ifscCode;
  private AccountType type;
  private boolean isActive;
  private BigDecimal balance;
  private LocalDate accountOpenDate;
  private LocalDate accountClosedDate;
  private boolean isAccountFullyLoaded;
}
