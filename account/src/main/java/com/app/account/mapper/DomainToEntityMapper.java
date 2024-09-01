package com.app.account.mapper;

import com.app.account.entity.AccountEntity;
import com.app.model.AccountRequest;

public interface DomainToEntityMapper {
  AccountEntity map(AccountRequest accountRequest);
}
