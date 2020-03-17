package com.insa.datasProcessingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//http://localhost:8082
@SpringBootApplication
@EnableDiscoveryClient
public class DatasProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatasProcessingApplication.class, args);
	}

}
