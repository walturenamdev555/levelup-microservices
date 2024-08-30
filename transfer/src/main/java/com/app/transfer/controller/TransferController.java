package com.app.transfer.controller;

import com.app.transfer.domain.Account;
import com.app.transfer.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transfers")
public class TransferController {

  @Autowired AccountService accountService;

  @GetMapping("/getAllAccounts")
  public ResponseEntity<List<Account>> getAccounts() {
    return ResponseEntity.ok().body(accountService.getAccounts());
  }

  @GetMapping("/accountNumber/{accountNumber}")
  public ResponseEntity<Account> getAccountByNumber(@PathVariable Long accountNumber) {
    return ResponseEntity.ok().body(accountService.getByAccountNumber(accountNumber));
  }

  @GetMapping("/getAllAccounts/{accountId}")
  public ResponseEntity<Account> getAccountById(@PathVariable String accountId) {
    return ResponseEntity.ok().body(accountService.getByAccountId(accountId));
  }

  @GetMapping("/status")
  public ResponseEntity<String> getStatus() {
    return ResponseEntity.ok().body("Transfer Service running successfully");
  }
}
