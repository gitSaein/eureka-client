package com.saeinlee.eureka_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/ping")
    public ResponseEntity<List<ServiceInstance>> mainPing() {
        List<ServiceInstance> instanceList = discoveryClient.getInstances("service-1");
        System.out.println("INSTANCES: count = " + instanceList.size());
        instanceList.forEach(it->System.out.println("INSTANCES: id=" + it.getServiceId() + "port= " + it.getPort()));
        return ResponseEntity.ok(instanceList);
    }
}
