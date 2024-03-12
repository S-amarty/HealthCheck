package com.eaiftpHealthCheck.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HealthCheckDto {
	
	public List<String> url;

	public List<String> getUrl() {
		return url;
	}

	public void setUrl(List<String> url) {
		this.url = url;
	}
}

//Application DTO with ID and NAME
//Application Details DTO with respective coloum