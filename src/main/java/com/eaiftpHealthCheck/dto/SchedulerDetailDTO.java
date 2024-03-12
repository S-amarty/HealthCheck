package com.eaiftpHealthCheck.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "scheduler_detail")
public class SchedulerDetailDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int application_id;
    private String environment_name;
    private String application_type;
    private String url;
    private int status;
    private String timestamp;
    


    public SchedulerDetailDTO(int id, int application_id, String environment_name, String application_type, String url,
    int status, String timestamp) {
    this.id = id;
    this.application_id = application_id;
    this.environment_name = environment_name;
    this.application_type = application_type;
    this.url = url;
    this.status = status;
    this.timestamp = timestamp;
}
    
    public SchedulerDetailDTO() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplication_id() {
        return application_id;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }

    public String getEnvironment_name() {
        return environment_name;
    }

    public void setEnvironment_name(String environment_name) {
        this.environment_name = environment_name;
    }

    public String getApplication_type() {
        return application_type;
    }

    public void setApplication_type(String application_type) {
        this.application_type = application_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
}
