package com.eaiftpHealthCheck.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eaiftpHealthCheck.dto.ApplicationDTO;
import com.eaiftpHealthCheck.dto.ApplicationDetailDTO;

@SuppressWarnings("rawtypes")
@Repository

public interface ApplicationDao extends CrudRepository <ApplicationDTO,Integer> {
    
    public List<ApplicationDTO> findAll();
   // public List<ApplicationDetailDTO> findByApplicationId(int applicationId);

}
