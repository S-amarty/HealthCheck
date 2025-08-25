package com.HealthCheck;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages={"com.eaiftpHealthCheck.controller","com.eaiftpHealthCheck.dto", "com.eaiftpHealthCheck.service","com.eaiftpHealthCheck.serviceImpl"})

public class HealthCheckApplication  {

	public static void main(String[] args) {
		SpringApplication.run(EaiftpHealthCheckApplication.class, args);
	}

	@Bean
	 public RestTemplate restTemplate() {
	     return new RestTemplate();
	 }
	
	@SuppressWarnings("null")
	@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}

