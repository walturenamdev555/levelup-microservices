package com.app.transfer;

import com.app.transfer.domain.Status;
import com.app.transfer.domain.Transfer;
import com.app.transfer.domain.TransferAmount;
import com.app.transfer.entity.TransferEntity;

public class Mapper {
  public static Transfer map(TransferEntity entity) {
    return Transfer.builder()
        .transactionId(entity.getTransactionId())
        .type(entity.getType())
        .status(Status.valueOf(entity.getStatus().name()))
        .fromAccountNumber(entity.getFromAccountNumber())
        .toAccountNumber(entity.getToAccountNumber())
        .transferAmount(
            TransferAmount.builder()
                .amount(entity.getTransferAmount().getAmount())
                .fees(entity.getTransferAmount().getFees())
                .build())
        .build();
  }
}
