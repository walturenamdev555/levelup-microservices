package com.app.transfer.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class TransferAmount {
  private BigDecimal amount;
  private BigDecimal fees;
}
