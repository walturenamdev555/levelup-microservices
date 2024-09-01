package com.app.account.mapper;

import com.app.account.domain.Account;
import com.app.account.domain.AccountType;
import com.app.account.entity.AccountEntity;
import com.app.model.AccountRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Component
public class DomainToEntityMapperImpl implements DomainToEntityMapper {
  @Override
  public AccountEntity map(AccountRequest accountRequest) {
    int num = new Random().nextInt(100_000, 1_000_000);
    AccountEntity entity = new AccountEntity();
    entity.setAccountId(UUID.randomUUID().toString());
    Long accountNumber = Long.valueOf("00" + num);
    entity.setAccountNumber(accountNumber);
    entity.setAccountHolderName(accountRequest.getAccountHolderName());
    entity.setIfscCode(
        accountRequest.getIfscCode() != null ? accountRequest.getIfscCode() : "HDFC2222");
    entity.setBalance(BigDecimal.valueOf(accountRequest.getBalance()));
    entity.setType(AccountType.valueOf(accountRequest.getAccountType().getValue()));
    entity.setActive(true);
    entity.setAccountOpenDate(LocalDateTime.now());
    return entity;
  }
}
