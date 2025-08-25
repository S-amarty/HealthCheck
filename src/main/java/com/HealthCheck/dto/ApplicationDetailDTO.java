package com.HealthCheck.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "application_detail")
public class ApplicationDetailDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private ApplicationDTO application;



    private String environment_name;
    private String application_type;
    private String url;

    public ApplicationDetailDTO() {
    }

    // getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}