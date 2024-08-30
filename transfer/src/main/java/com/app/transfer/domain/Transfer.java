package com.app.transfer.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Transfer {
  private String transactionId;
  private Long fromAccountNumber;
  private Long toAccountNumber;
  private TransferType type;
  private TransferAmount transferAmount;
  private Status status;
}
