package com.app.transfer.feign;

import com.app.transfer.domain.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "account-service")
public interface AccountServiceFeign {

  @GetMapping("/accounts/findAll")
  List<Account> getAllAccounts();

  @GetMapping("/accounts/accountNumber/{accountNumber}")
  Account getByAccountNumber(@PathVariable Long accountNumber);

  @GetMapping("/accounts/accountId/{accountId}")
  Account getByAccountId(@PathVariable String accountId);

  @PutMapping("/accounts/updateBalance")
  Account updateBalance(@RequestBody Account account);
}
