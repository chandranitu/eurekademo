package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableEurekaServer

public class EurekaServerApplication {
	//private static final Logger logger = LoggerFactory.getLogger(EurekaServerApplication.class);

	public static void main(String[] args) {
		//logger.info("Example log from {}", EurekaServerApplication.class.getSimpleName());
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
