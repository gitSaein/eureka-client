package com.saeinlee.eureka_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Controller
public class ConsumerContrillerClient {

    @Autowired
    private DiscoveryClient discoveryClient;

    public void getEmployee() throws RestClientException, IOException{
        List<ServiceInstance> instanceList = discoveryClient.getInstances("zuul-service");
        ServiceInstance serviceInstance = instanceList.get(0);

        String baseUrl = serviceInstance.getUri().toString();
        baseUrl=baseUrl+"/producer/employee";
        System.out.println("baseUrl: " + baseUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = null;

        try{
            responseEntity = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
        }catch (Exception e){
            System.out.println(responseEntity.getBody());
        }
    }

    private static HttpEntity<?> getHeaders() throws IOException{
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }

}
