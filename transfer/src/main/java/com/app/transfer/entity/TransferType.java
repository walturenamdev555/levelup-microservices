package com.app.transfer.entity;

public enum TransferType {
  BANK("bank"),
  UPI("UPI"),
  IMPS("IMPS"),
  RTGS("RTGS"),
  CHECK("CHECK");
  private String type;

  private TransferType(String type) {
    this.type = type;
  }
}
