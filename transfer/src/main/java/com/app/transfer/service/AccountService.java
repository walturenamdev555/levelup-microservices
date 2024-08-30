package com.app.transfer.service;

import com.app.transfer.domain.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AccountService {
  public List<Account> getAccounts();

  Account getByAccountNumber(Long accountNumber);

  Account getByAccountId(String accountId);
}
