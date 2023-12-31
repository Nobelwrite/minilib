package com.minilibraryproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
public class MiniLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniLibraryApplication.class, args);
	}

}
