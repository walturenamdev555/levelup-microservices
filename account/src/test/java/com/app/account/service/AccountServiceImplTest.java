package com.app.account.service;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.app.account.entity.AccountEntity;
import com.app.account.mapper.DomainToEntityMapper;
import com.app.account.repo.AccountRepository;
import com.app.model.AccountRequest;
import com.app.model.AccountRequestAccountType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

  @InjectMocks private AccountServiceImpl accountService;
  @Mock private AccountRepository repository;
  // @Spy private EntityToDomainMapper mapper;
  @Mock private DomainToEntityMapper domainToEntityMapper;

  @Test
  void test_account_added_successfully() {
    AccountRequest accountRequest =
        AccountRequest.builder()
            .balance(10.0)
            .accountType(AccountRequestAccountType.CURRENT)
            .build();
    AccountEntity entity = new AccountEntity();
    when(domainToEntityMapper.map(accountRequest)).thenReturn(entity);
    when(repository.save(entity)).thenReturn(entity);
    accountService.addAccount(accountRequest);
    Assertions.assertNotNull(entity);
    verify(domainToEntityMapper).map(accountRequest);
    verify(repository).save(entity);
    verifyNoMoreInteractions(domainToEntityMapper, repository);
  }
}
