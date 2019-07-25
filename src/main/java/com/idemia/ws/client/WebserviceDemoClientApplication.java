package com.idemia.ws.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.idemia.ws"})
public class WebserviceDemoClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebserviceDemoClientApplication.class, args);
	}

}
