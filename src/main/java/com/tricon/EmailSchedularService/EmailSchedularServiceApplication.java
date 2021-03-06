package com.tricon.EmailSchedularService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
public class EmailSchedularServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailSchedularServiceApplication.class, args);
	}
}
