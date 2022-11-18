package com.ddis.mongotask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DdisMongoTaskApplication {

	public static void main(String[] args){
		new SpringApplicationBuilder() //
				.sources(DdisMongoTaskApplication.class)//
				.run(args);
	}

}
