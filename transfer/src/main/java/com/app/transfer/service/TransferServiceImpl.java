package com.app.transfer.service;

import com.app.transfer.Mapper;
import com.app.transfer.domain.Account;
import com.app.transfer.domain.Transfer;
import com.app.transfer.entity.TransferAmount;
import com.app.transfer.entity.Status;
import com.app.transfer.entity.TransferEntity;
import com.app.transfer.feign.AccountServiceFeign;
import com.app.transfer.repo.TransferRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferServiceImpl implements TransferService {
  private final AccountServiceFeign accountServiceFeign;

  private final TransferRepo transferRepo;

  @Override
  @Transactional
  public Transfer transfer(Transfer transfer) {
    Account fromAccount =
        accountServiceFeign.getByAccountNumber(transfer.getFromAccountNumber());
    Account toAccount = accountServiceFeign.getByAccountNumber(transfer.getToAccountNumber());
    BigDecimal transferAmount = transfer.getTransferAmount().getAmount();
    BigDecimal fees = calculateTransferFees(transfer);

    if (fromAccount.getBalance().floatValue()
        >= transfer.getTransferAmount().getAmount().floatValue()) {
      fromAccount.setBalance(fromAccount.getBalance().subtract(transferAmount.add(fees)));
      toAccount.setBalance(toAccount.getBalance().add(transferAmount));
      Account account = accountServiceFeign.updateBalance(fromAccount);
      Account account1 = accountServiceFeign.updateBalance(toAccount);
      log.info(String.valueOf(account));
      log.info(String.valueOf(account1));
    }
    // TODO Update from and to account

    TransferEntity entity = new TransferEntity();
    TransferAmount transferAmount1 = new TransferAmount();
    entity.setTransactionId(UUID.randomUUID().toString());
    entity.setFromAccountNumber(transfer.getFromAccountNumber());
    entity.setToAccountNumber(transfer.getToAccountNumber());
    entity.setStatus(Status.COMPLETED);
    entity.setType(transfer.getType());

    transferAmount1.setAmount(transfer.getTransferAmount().getAmount());
    transferAmount1.setFees(fees);
    entity.setTransferAmount(transferAmount1);
    TransferEntity save = transferRepo.save(entity);
    log.info(String.valueOf(save));
    return save != null ? transfer : null;
  }

  private BigDecimal calculateTransferFees(Transfer transfer) {
    double transferAmount = transfer.getTransferAmount().getAmount().doubleValue();
    BigDecimal fees = BigDecimal.ZERO;
    if (transferAmount < 100000) {
      fees = fees.add(BigDecimal.valueOf(10.0));
    } else if (transferAmount > 100000 && transferAmount <= 500000) {
      fees = fees.add(BigDecimal.valueOf(20.0));
    } else if (transferAmount >= 500001 && transferAmount <= 1000000) {
      fees = fees.add(BigDecimal.valueOf(50.0));
    } else {
      fees = fees.add(BigDecimal.valueOf(100.0));
    }
    return fees;
  }

  public List<Transfer> getAllTransfers() {
    return transferRepo.findAll().stream().map(Mapper::map).toList();
  }

  public Transfer getAllByTransferId(String transferId) {
    return Mapper.map(transferRepo.findByTransactionId(transferId));
  }

  public List<Transfer> findByAccountId(Long accountId) {
    return transferRepo.findByFromAccountNumberOrToAccountNumber(accountId, accountId).stream()
        .map(Mapper::map)
        .toList();
  }
}
