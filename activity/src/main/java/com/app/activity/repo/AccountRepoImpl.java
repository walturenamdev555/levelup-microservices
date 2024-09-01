package com.app.activity.repo;

import com.app.activity.domain.Account;
import com.app.activity.feign.AccountServiceFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountRepoImpl implements AccountRepo {
  private final AccountServiceFeign accountServiceFeign;

  @Override
  public Account getAccountById(Long accountId) {
    return accountServiceFeign.getByAccountNumber(accountId).getAccounts().get(0);
  }
}
