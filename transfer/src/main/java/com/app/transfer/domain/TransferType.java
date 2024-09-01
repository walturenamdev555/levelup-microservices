package com.app.transfer.domain;


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
