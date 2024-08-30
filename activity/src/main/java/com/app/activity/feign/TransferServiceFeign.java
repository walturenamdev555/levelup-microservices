package com.app.activity.feign;

import com.app.activity.domain.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "transfer-service")
public interface TransferServiceFeign {

  @GetMapping("/transfers/getTransfers")
  List<Transfer> getActivities();

  @GetMapping("/transfers/transferId/{transferId}")
  Transfer getActivityById(@PathVariable String transferId);

  @GetMapping("/transfers/accountNumber/{accountNumber}")
  List<Transfer> getActivitiesByAccountId(@PathVariable Long accountNumber);
}
