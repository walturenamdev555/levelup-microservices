package com.app.activity.service;

import com.app.activity.domain.Activity;

import java.util.List;

public interface ActivityService {
    List<Activity> getActivities();
    Activity getActivityById(String transferId);

    List<Activity> getActivityByAccountNumber(Long accountNumber);
}
