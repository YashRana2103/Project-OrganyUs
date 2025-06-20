package com.organyus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing // required for createdAt and updatedAt
public class OrganyUsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganyUsApplication.class, args);
	}

}
