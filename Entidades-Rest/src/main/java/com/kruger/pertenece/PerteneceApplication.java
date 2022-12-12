package com.kruger.pertenece;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PerteneceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerteneceApplication.class, args);
	}

}
