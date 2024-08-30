package com.app.transfer.repo;

import com.app.transfer.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepo extends JpaRepository<TransferEntity, String> {

  public TransferEntity findByTransactionId(String transactionId);

  List<TransferEntity> findByFromAccountNumberOrToAccountNumber(Long fromAccountNumber, Long toAccountNumber);
}
