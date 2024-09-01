package com.app.account.mapper;

import com.app.account.domain.Account;
import com.app.account.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EntityToDomainMapper {
  EntityToDomainMapper INSTANCE = Mappers.getMapper(EntityToDomainMapper.class);

  @Mapping(target = "isAccountFullyLoaded", constant = "true")
  @Mapping(target = "isActive", source = "active")
  Account map(AccountEntity accountEntity);
}
