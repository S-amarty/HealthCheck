package com.eaiftpHealthCheck.dto;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "application")
public class ApplicationDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    private List<ApplicationDetailDTO> applicationDetails;

    public ApplicationDTO() {
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ApplicationDetailDTO> getApplicationDetails() {
        return applicationDetails;
    }

    public void setApplicationDetails(List<ApplicationDetailDTO> applicationDetails) {
        this.applicationDetails = applicationDetails;
    }
}
