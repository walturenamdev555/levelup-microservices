package com.app.account.mapper;

import com.app.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountDomainToAccountApiMapper {
  AccountDomainToAccountApiMapper INSTANCE =
      Mappers.getMapper(AccountDomainToAccountApiMapper.class);

  @Mapping(target = "isAccountFullyLoaded", source = "accountFullyLoaded")
  @Mapping(target = "isActive", source = "active")
  Account map(com.app.account.domain.Account account);
}
