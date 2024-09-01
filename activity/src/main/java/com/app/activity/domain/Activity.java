package com.app.activity.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Activity {
  private String transactionId;
  private Account fromAccount;
  private Account toAccount;
  private TransferType type;
  private TransferAmount transferAmount;
  private LocalDateTime transactionDate;
  private Status status;
}
