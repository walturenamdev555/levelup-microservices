package com.app.transfer.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransferType {
  BANK("bank"),
  UPI("UPI"),
  IMPS("IMPS"),
  RTGS("RTGS"),
  CHECK("CHECK");

  private String type;
  TransferType(String type) {
    this.type = type;
  }

}
