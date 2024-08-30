package com.app.activity.domain;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransferAmount {
  private BigDecimal amount;
  private BigDecimal fees;
}
