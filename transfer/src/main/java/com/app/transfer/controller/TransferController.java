package com.app.transfer.controller;

import com.app.transfer.domain.Account;
import com.app.transfer.domain.Transfer;
import com.app.transfer.service.AccountService;
import com.app.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transfers")
public class TransferController {

  @Autowired AccountService accountService;
  @Autowired TransferService transferService;

  @GetMapping("/getTransfers")
  public ResponseEntity<List<Transfer>> getAllTransfers() {
    return ResponseEntity.ok().body(transferService.getAllTransfers());
  }

  @GetMapping("/transferId/{transferId}")
  public ResponseEntity<Transfer> getAllByTransferId(@PathVariable String transferId) {
    return ResponseEntity.ok().body(transferService.getAllByTransferId(transferId));
  }

  @GetMapping("/accountNumber/{accountNumber}")
  public ResponseEntity<List<Transfer>> getAllByAccountId(@PathVariable Long accountNumber) {
    return ResponseEntity.ok().body(transferService.findByAccountId(accountNumber));
  }

  @PostMapping
  public Transfer transfer(@RequestBody Transfer transfer) {
    return transferService.transfer(transfer);
  }

  @GetMapping("/accounts/getAccounts")
  public ResponseEntity<List<Account>> getAccounts() {
    return ResponseEntity.ok().body(accountService.getAccounts());
  }

  @GetMapping("/accounts/accountNumber/{accountNumber}")
  public ResponseEntity<Account> getAccountByNumber(@PathVariable Long accountNumber) {
    return ResponseEntity.ok().body(accountService.getByAccountNumber(accountNumber));
  }

  @GetMapping("/accounts/accountId/{accountId}")
  public ResponseEntity<Account> getAccountById(@PathVariable String accountId) {
    return ResponseEntity.ok().body(accountService.getByAccountId(accountId));
  }

  @GetMapping("/status")
  public ResponseEntity<String> getStatus() {
    return ResponseEntity.ok().body("Transfer Service running successfully");
  }
}
