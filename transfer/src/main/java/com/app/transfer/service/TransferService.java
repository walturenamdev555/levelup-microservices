package com.app.transfer.service;

import com.app.transfer.domain.Transfer;

import java.util.List;

public interface TransferService {
  public Transfer transfer(Transfer transfer);

  public List<Transfer> getAllTransfers();

  public Transfer getAllByTransferId(String transferId);
  ;

  public List<Transfer> findByAccountId(Long accountId);
}
