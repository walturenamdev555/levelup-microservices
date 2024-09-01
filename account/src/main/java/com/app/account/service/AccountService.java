package com.app.account.service;

import com.app.account.domain.Account;
import com.app.model.AccountRequest;

import java.util.List;

public interface AccountService {
    Account addAccount(AccountRequest  account);

    Account updateBalance(AccountRequest account);

    String addDefaultAccounts();

    List<Account> getAllAccounts();

    Account getByAccountNumber(Long accountNumber);

    Account getById(String id);
}