package com.eaiftpHealthCheck.service;

import com.eaiftpHealthCheck.dto.ApplicationDetailDTO;
import com.eaiftpHealthCheck.dto.SchedulerDetailDTO;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

public interface HealthCheckService {
    List<HttpStatus> getHttpStatus(int applicationId);
    Map<Integer, String> getApplicationMap();
    List<SchedulerDetailDTO> getAllSchedulerDetails();
    List<ApplicationDetailDTO> getApplicationList(int application_id);
    List<HttpStatus> checkMultipleDatabaseConnections();
}
