package com.HealthCheck.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HealthCheck.dto.ApplicationDTO;

@Repository

public interface ApplicationDao extends CrudRepository <ApplicationDTO,Integer> {
    
    public List<ApplicationDTO> findAll();
   // public List<ApplicationDetailDTO> findByApplicationId(int applicationId);

}
