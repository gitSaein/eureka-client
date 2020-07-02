package com.saeinlee.eureka_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/ping")
    public ResponseEntity<String> mainPing() {
        return ResponseEntity.ok("pong");
    }
}
