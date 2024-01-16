package com.example.consistenthashing.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

/**
 * Author: Karanjot Singh
 * User:karanjotsingh
 * Date:2024-01-15
 * Time:21:35
 */
@RestController
public class HeartBeatController {
    @GetMapping("heartbeat")
    public ResponseEntity<Long> getCurrentTimeStamp() {
        return ResponseEntity.ok(Instant.now().getEpochSecond());
    }
}
