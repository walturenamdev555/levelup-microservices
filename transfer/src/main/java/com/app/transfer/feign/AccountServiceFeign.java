package com.app.transfer.feign;

import com.app.transfer.domain.Account;
import com.app.transfer.domain.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "account-service")
public interface AccountServiceFeign {

  @GetMapping("/accounts/findAll")
  AccountResponse findAllAccounts();

  @GetMapping("/accounts/accountNumber/{accountNumber}")
  AccountResponse getByAccountNumber(@PathVariable Long accountNumber);

  @GetMapping("/accounts/accountId/{accountId}")
  AccountResponse getByAccountId(@PathVariable String accountId);

  @PutMapping("/accounts/updateBalance")
  AccountResponse updateBalance(@RequestBody Account account);
}
