package com.saeinlee.eureka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {
	
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

}
