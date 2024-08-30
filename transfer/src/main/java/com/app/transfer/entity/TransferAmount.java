package com.app.transfer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.math.BigDecimal;

@Embeddable
@Data
public class TransferAmount {
  @Column(name = "amount", nullable = false)
  private BigDecimal amount;

  @Column(name = "fees", nullable = true)
  private BigDecimal fees;
}
