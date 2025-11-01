package com.HealthCheck.dao;


import com.HealthCheck.dto.SchedulerDetailDTO;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface SchedulerDetailDAO extends CrudRepository <SchedulerDetailDTO,Integer> {

    //public List<ApplicationDetailDTO> findByApplicationId(int application_id);
    //public List<SchedulerDetailDTO> findAll();

}

