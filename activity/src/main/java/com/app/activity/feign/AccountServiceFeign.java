package com.app.activity.feign;

import com.app.activity.domain.Account;
import com.app.activity.domain.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service")
public interface AccountServiceFeign {
  @GetMapping("/accounts/accountNumber/{accountNumber}")
  AccountResponse getByAccountNumber(@PathVariable Long accountNumber);
}
