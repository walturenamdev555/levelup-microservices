package com.app.activity.mapper;

import com.app.activity.domain.Account;
import com.app.activity.domain.Activity;
import com.app.activity.domain.Transfer;
import com.app.activity.domain.TransferAmount;

import java.util.Map;

public class ActivityMapper {
  public static Activity map(Transfer transfer, Map<Long, Account> map) {
    return Activity.builder()
        .transactionId(transfer.getTransactionId())
        .type(transfer.getType())
        .status(transfer.getStatus())
        .transferAmount(
            TransferAmount.builder()
                .amount(transfer.getTransferAmount().getAmount())
                .fees(transfer.getTransferAmount().getFees())
                .build())
        .fromAccount(map.get(transfer.getFromAccountNumber()))
        .toAccount(map.get(transfer.getToAccountNumber()))
        .build();
  }
}
