package com.satya.spring_boot_assignment.api_gateway;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
//		Dotenv dotenv = Dotenv.configure()
//				.directory("/home/satyam/spring/spring_boot_assignment-master/auth-service/.env")
//				.load();
//
//		System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET"));
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
