package com.app.activity.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Activity {
  private String transactionId;
  private Account fromAccount;
  private Account toAccount;
  private TransferType type;
  private TransferAmount transferAmount;
  private Status status;
}
