package com.app.account.service;

import com.app.account.domain.Account;
import com.app.account.domain.AccountType;
import com.app.account.entity.AccountEntity;
import com.app.account.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

  private final AccountRepository repository;

  @Override
  public Account addAccount(Account account) {
    System.out.println(account);
    AccountEntity entity = new AccountEntity();
    BeanUtils.copyProperties(account, entity);
    entity.setId(UUID.randomUUID().toString());
    entity.setBalance(BigDecimal.ZERO);
    repository.save(entity);
    Account account1 = new Account();
    BeanUtils.copyProperties(repository.save(entity), account1);
    return account1;
  }

  @Override
  @Transactional
  public Account updateBalance(Account account) {
    Optional<AccountEntity> accountEntity =
        repository.findByAccountNumber(account.getAccountNumber());
    return accountEntity
        .map(
            entity -> {
              entity.setBalance(account.getBalance());
              return mapEntityToAccount(repository.save(entity));
            })
        .orElseThrow(() -> new RuntimeException("Account Not Fund"));
  }

  @Override
  public List<Account> getAllAccounts() {
    List<AccountEntity> all = repository.findAll();
    return Optional.ofNullable(all)
        .map(result -> result.stream().map(AccountServiceImpl::mapEntityToAccount).toList())
        .orElse(List.of());
  }

  @Override
  public Account getByAccountNumber(Long accountNumber) {
    return repository
        .findByAccountNumber(accountNumber)
        .map(AccountServiceImpl::mapEntityToAccount)
        .orElse(null);
  }

  @Override
  public String addDefaultAccounts() {
    List<AccountEntity> defaultAccounts = getDefaultAccounts();
    List<AccountEntity> accountEntities = repository.saveAllAndFlush(defaultAccounts);
    return Optional.ofNullable(accountEntities)
        .map(list -> "Accounts saved successfully")
        .orElse("Accounts failed to save");
  }

  @Override
  public Account getById(String id) {
    return repository.findById(id).map(AccountServiceImpl::mapEntityToAccount).orElse(null);
  }

  private static Account mapEntityToAccount(AccountEntity entity) {
    return Account.builder()
        .id(entity.getId())
        .accountNumber(entity.getAccountNumber())
        .accountHolderName(entity.getAccountHolderName())
        .ifscCode(entity.getIfscCode())
        .type(entity.getType())
        .isActive(entity.isActive())
        .balance(entity.getBalance())
        .build();
  }

  private List<AccountEntity> getDefaultAccounts() {
    AccountEntity entity1 = new AccountEntity();
    AccountEntity entity2 = new AccountEntity();
    AccountEntity entity3 = new AccountEntity();
    AccountEntity entity4 = new AccountEntity();
    AccountEntity entity5 = new AccountEntity();
    AccountEntity hdfcAccount = new AccountEntity();

    entity1.setId(UUID.randomUUID().toString());
    entity1.setAccountNumber(11112222L);
    entity1.setAccountHolderName("Namdev Walture");
    entity1.setIfscCode("HDFC1111");
    entity1.setType(AccountType.SALARY);
    entity1.setBalance(BigDecimal.ZERO);
    entity1.setActive(true);

    entity2.setId(UUID.randomUUID().toString());
    entity2.setAccountNumber(22223333L);
    entity2.setAccountHolderName("Pawan Gawande");
    entity2.setIfscCode("HDFC1111");
    entity2.setType(AccountType.SALARY);
    entity2.setBalance(BigDecimal.ZERO);
    entity2.setActive(true);

    entity3.setId(UUID.randomUUID().toString());
    entity3.setAccountNumber(33334444L);
    entity3.setAccountHolderName("Akshay Netankar");
    entity3.setIfscCode("HDFC1111");
    entity3.setType(AccountType.PF);
    entity3.setBalance(BigDecimal.ZERO);
    entity3.setActive(true);

    entity4.setId(UUID.randomUUID().toString());
    entity4.setAccountNumber(44445555L);
    entity4.setAccountHolderName("Vikas Gaikwad");
    entity4.setIfscCode("HDFC2222");
    entity4.setType(AccountType.SAVING);
    entity4.setBalance(BigDecimal.ZERO);
    entity4.setActive(true);

    entity5.setId(UUID.randomUUID().toString());
    entity5.setAccountNumber(55556666L);
    entity5.setAccountHolderName("Kishor Hiwale");
    entity5.setIfscCode("HDFC2222");
    entity5.setType(AccountType.CURRENT);
    entity5.setBalance(BigDecimal.ZERO);
    entity5.setActive(true);

    hdfcAccount.setId(UUID.randomUUID().toString());
    hdfcAccount.setAccountNumber(88888888L);
    hdfcAccount.setAccountHolderName("HDFC Bank");
    hdfcAccount.setIfscCode("HDFC0000");
    hdfcAccount.setType(AccountType.CURRENT);
    hdfcAccount.setBalance(BigDecimal.valueOf(10000000000.0));
    hdfcAccount.setActive(true);

    List<AccountEntity> list = new ArrayList();
    list.add(entity1);
    list.add(entity2);
    list.add(entity3);
    list.add(entity4);
    list.add(entity5);
    list.add(hdfcAccount);
    return list;
  }
}