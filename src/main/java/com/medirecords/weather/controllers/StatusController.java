package com.medirecords.weather.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/status-check")
public class StatusController {
    @GetMapping("/health")
    public ResponseEntity<String> getHealthCheckStatus() {
        return new ResponseEntity<String>("UP", HttpStatus.valueOf(200));
    }

    @GetMapping("/version")
    public ResponseEntity<String> getApiVersion() {
        return new ResponseEntity<String>("The current version is 1.0.0", HttpStatus.valueOf(200));
    }
}
