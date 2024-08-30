package com.app.activity.repo;

import com.app.activity.domain.Account;

public interface AccountRepo {
    Account getAccountById(Long accountId);
}
