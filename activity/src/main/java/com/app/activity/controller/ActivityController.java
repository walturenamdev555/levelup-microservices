package com.app.activity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activities")
public class ActivityController {
  @GetMapping("/status")
  public ResponseEntity<String> getStatus() {
    return ResponseEntity.ok().body("Activity Service running successfully");
  }
}
