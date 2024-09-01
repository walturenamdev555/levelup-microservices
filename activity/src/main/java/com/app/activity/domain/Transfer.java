package com.app.activity.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Transfer {
  private String transactionId;
  private Long fromAccountNumber;
  private Long toAccountNumber;
  private TransferType type;
  private TransferAmount transferAmount;
  private LocalDateTime transactionDate;
  private Status status;
}
