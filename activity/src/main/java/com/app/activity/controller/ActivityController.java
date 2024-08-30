package com.app.activity.controller;

import com.app.activity.domain.Activity;
import com.app.activity.domain.Transfer;
import com.app.activity.repo.TransferRepo;
import com.app.activity.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

  @Autowired private ActivityService activityService;

  @Autowired private TransferRepo transferRepo;

  @GetMapping("/findAll")
  public List<Activity> getActivities() {
    return activityService.getActivities();
  }

  @GetMapping("/transferId/{transferId}")
  public Activity getActivityById(@PathVariable String transferId) {
    return activityService.getActivityById(transferId);
  }

  @GetMapping("/accountNumber/{accountNumber}")
  public List<Activity> getActivityByAccountNumber(@PathVariable Long accountNumber) {
    return activityService.getActivityByAccountNumber(accountNumber);
  }

  @GetMapping("/status")
  public ResponseEntity<String> getStatus() {
    return ResponseEntity.ok().body("Activity Service running successfully");
  }
}
