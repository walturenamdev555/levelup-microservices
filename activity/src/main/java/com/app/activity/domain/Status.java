package com.app.activity.domain;

public enum Status {
  COMPLETED("COMPLETED"),
  IN_PROGRESS("IN_PROGRESS"),
  CANCELLED("CANCELLED"),
  FAILED("FAILED");

  private String status;

  Status(String status) {
    this.status = status;
  }
}
