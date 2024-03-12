package com.eaiftpHealthCheck.dao;


import com.eaiftpHealthCheck.dto.ApplicationDTO;
import com.eaiftpHealthCheck.dto.ApplicationDetailDTO;
import com.eaiftpHealthCheck.dto.SchedulerDetailDTO;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

@Repository
public interface SchedulerDetailDAO extends CrudRepository <SchedulerDetailDTO,Integer> {

    //public List<ApplicationDetailDTO> findByApplicationId(int application_id);
    //public List<SchedulerDetailDTO> findAll();

}

