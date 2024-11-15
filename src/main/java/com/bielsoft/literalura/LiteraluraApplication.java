package com.bielsoft.literalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

}
