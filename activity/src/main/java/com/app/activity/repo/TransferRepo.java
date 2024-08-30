package com.app.activity.repo;

import com.app.activity.domain.Transfer;

import java.util.List;

public interface TransferRepo {

  Transfer getActivityById(String transferId);

  List<Transfer> getActivities();

  List<Transfer> getActivitiesByAccountId(Long accountNumber);
}
