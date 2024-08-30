package com.app.transfer.service;

import com.app.transfer.domain.Account;
import com.app.transfer.feign.AccountServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

  @Autowired private AccountServiceFeign accountFeign;

  @Override
  public List<Account> getAccounts() {
    return accountFeign.getAllAccounts();
  }

  @Override
  public Account getByAccountNumber(Long accountNumber) {
    return accountFeign.getByAccountNumber(accountNumber);
  }

  @Override
  public Account getByAccountId(String accountId) {
    return accountFeign.getByAccountId(accountId);
  }
}
