package com.app.transfer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

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

  @Column(name = "transactionDate", nullable = false)
  private LocalDateTime transactionDate;

  @Embedded private TransferAmount transferAmount;

  @Enumerated(EnumType.STRING)
  private Status status;
}
