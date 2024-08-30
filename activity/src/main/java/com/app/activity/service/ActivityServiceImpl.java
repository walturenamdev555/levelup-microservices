package com.app.activity.service;

import com.app.activity.domain.Account;
import com.app.activity.domain.Activity;
import com.app.activity.domain.Transfer;
import com.app.activity.mapper.ActivityMapper;
import com.app.activity.repo.AccountRepo;
import com.app.activity.repo.TransferRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

  private final AccountRepo accountRepo;
  private final TransferRepo transferRepo;

  @Override
  public List<Activity> getActivities() {
    List<Transfer> activities = transferRepo.getActivities();
    return mapActivities(activities);
  }

  @Override
  public Activity getActivityById(String transferId) {
    Transfer activityById = transferRepo.getActivityById(transferId);
    return mapActivities(List.of(activityById)).get(0);
  }

  @Override
  public List<Activity> getActivityByAccountNumber(Long accountNumber) {
    List<Transfer> activities = transferRepo.getActivitiesByAccountId(accountNumber);
    return mapActivities(activities);
  }

  private List<Activity> mapActivities(List<Transfer> transfers) {
    Map<Long, Account> map = new HashMap<>();
    transfers.forEach(
        activity -> {
          map.computeIfAbsent(activity.getToAccountNumber(), accountRepo::getAccountById);
          map.computeIfAbsent(activity.getFromAccountNumber(), accountRepo::getAccountById);
        });
    return transfers.stream().map(transfer -> ActivityMapper.map(transfer, map)).toList();
  }
}
