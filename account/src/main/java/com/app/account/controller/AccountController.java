package com.app.account.controller;

import com.app.account.domain.Account;
import com.app.account.mapper.AccountDomainToAccountApiMapper;
import com.app.account.service.AccountService;
import com.app.api.AccountsApi;
import com.app.model.AccountRequest;
import com.app.model.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController implements AccountsApi {

  @Autowired private AccountService accountService;

  private final AccountDomainToAccountApiMapper mapper = AccountDomainToAccountApiMapper.INSTANCE;

  @Override
  public AccountResponse addAccount(@RequestBody AccountRequest account) {
    return AccountResponse.builder()
        .accounts(List.of(mapper.map(accountService.addAccount(account))))
        .build();
  }

  @Override
  public AccountResponse findAllAccounts() {
    return AccountResponse.builder()
        .accounts(accountService.getAllAccounts().stream().map(mapper::map).toList())
        .build();
  }

  @Override
  public AccountResponse getAccountById(@PathVariable("accountId") String accountId) {
    return AccountResponse.builder()
        .accounts(List.of(mapper.map(accountService.getById(accountId))))
        .build();
  }

  @Override
  public AccountResponse getAccountByAccountNumber(
      @PathVariable("accountNumber") Long accountNumber) {
    return AccountResponse.builder()
        .accounts(List.of(mapper.map(accountService.getByAccountNumber(accountNumber))))
        .build();
  }

  @Override
  public AccountResponse updateBalance(@RequestBody AccountRequest account) {
    return AccountResponse.builder()
        .accounts(List.of(mapper.map(accountService.updateBalance(account))))
        .build();
  }

  @GetMapping("accounts/addDefaultAccounts")
  public ResponseEntity<String> addDefaultAccounts() {
    return ResponseEntity.ok(accountService.addDefaultAccounts());
  }

  // Checking git status
  @GetMapping("accounts/status")
  public ResponseEntity<String> getStatus() {
    return ResponseEntity.ok().body("Account Service running successfully");
  }
}
