package com.app.transfer.entity;

import com.app.transfer.domain.TransferType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TRANSFER")
@Data
public class TransferEntity {
  @Id
  @Column(name = "transactionId", nullable = false)
  private String transactionId;

  @Column(name = "fromAccountNumber", nullable = false)
  private Long fromAccountNumber;

  @Column(name = "toAccountNumber", nullable = false)
  private Long toAccountNumber;

  @Column(name = "type", nullable = false)
  @Enumerated(EnumType.STRING)
  private TransferType type;

  @Embedded private TransferAmount transferAmount;

  @Enumerated(EnumType.STRING)
  private Status status;
}
