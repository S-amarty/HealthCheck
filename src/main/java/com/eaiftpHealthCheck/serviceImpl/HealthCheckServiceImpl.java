package com.eaiftpHealthCheck.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.eaiftpHealthCheck.dao.ApplicationDao;
import com.eaiftpHealthCheck.dao.ApplicationDetailDAO;
import com.eaiftpHealthCheck.dao.SchedulerDetailDAO;
import com.eaiftpHealthCheck.dto.ApplicationDTO;
import com.eaiftpHealthCheck.dto.ApplicationDetailDTO;
import com.eaiftpHealthCheck.dto.DBCredentialDTO;
import com.eaiftpHealthCheck.dto.SchedulerDetailDTO;
import com.eaiftpHealthCheck.service.HealthCheckService;
import com.itextpdf.text.log.SysoCounter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@EnableScheduling
public class HealthCheckServiceImpl implements HealthCheckService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApplicationDao applicationDao;

    @Autowired
    private ApplicationDetailDAO applicationDetailDAO;

    @Autowired
    private SchedulerDetailDAO schedulerDetailDAO;

    @Scheduled(fixedRate = 6000000) // 15 minutes in milliseconds
    public void scheduledHealthCheck() {
        List<HttpStatus> httpStatusList = getHttpStatus(1);
        System.out.println("Scheduler: " + httpStatusList);
        saveSchedulerDetail(1);
    }

    @Override
    public List<HttpStatus> getHttpStatus(int applicationId) {
        List<ApplicationDetailDTO> urlList = applicationDetailDAO.findByApplicationId(applicationId);
        System.out.println("Url list: " + urlList.size());
        List<HttpStatus> httpStatusList = new ArrayList<>();
        try {
            for (ApplicationDetailDTO dto : urlList) {
                try {
                    ResponseEntity<String> responseEntity = restTemplate.getForEntity(dto.getUrl(), String.class);
                    httpStatusList.add((HttpStatus) responseEntity.getStatusCode());
                } catch (RestClientException e) {
                    System.out.println("Error for URL " + dto.getUrl() + ": " + e.getMessage());
                    httpStatusList.add(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
        }
        return httpStatusList;
    }

    @Override
    public Map<Integer, String> getApplicationMap() {
        List<ApplicationDTO> applicationList = applicationDao.findAll();
        return applicationList.stream().collect(Collectors.toMap(ApplicationDTO::getId, ApplicationDTO::getName));
    }

    @Override
    public List<SchedulerDetailDTO> getAllSchedulerDetails() {
        return (List<SchedulerDetailDTO>) schedulerDetailDAO.findAll();
    }

    @Override
    public List<ApplicationDetailDTO> getApplicationList(int application_id) {
        return applicationDetailDAO.findByApplicationId(application_id);
    }

    public void saveSchedulerDetail(int applicationId) {
        List<ApplicationDetailDTO> applicationDetailDTOList = applicationDetailDAO.findByApplicationId(applicationId);
        Date date = new Date();
        for (ApplicationDetailDTO dto : applicationDetailDTOList) {
            SchedulerDetailDTO schedulerDetailDTO = new SchedulerDetailDTO(); // Create a new object for each iteration
            schedulerDetailDTO.setApplication_id(1);
            schedulerDetailDTO.setEnvironment_name(dto.getEnvironment_name());
            schedulerDetailDTO.setApplication_type(dto.getApplication_type());
            schedulerDetailDTO.setUrl(dto.getUrl());
            
            if (!dto.getUrl().isEmpty()) {
                try {
                    ResponseEntity<String> responseEntity = restTemplate.getForEntity(dto.getUrl(), String.class);
                    schedulerDetailDTO.setStatus(responseEntity.getStatusCode().value());// Set the actual status code value
                } catch (RestClientException e) {
                    System.out.println("Error for URL " + dto.getUrl() + ": " + e.getMessage());
                    schedulerDetailDTO.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                }
            }
            
            schedulerDetailDTO.setTimestamp(date.toString());
            schedulerDetailDAO.save(schedulerDetailDTO);
        }
    }
    
    @Override
    public List<HttpStatus> checkMultipleDatabaseConnections() {
        List<HttpStatus> databaseStatusList = new ArrayList<>();
        List<DBCredentialDTO> DBCredentialDTOList = new ArrayList<>();
        DBCredentialDTO dbCredentialDTO = new DBCredentialDTO(null, 0, null, null, null);
        dbCredentialDTO.setHostname("tsrvldb0279");
        dbCredentialDTO.setPassword("TFTPSYSAPPL");
        dbCredentialDTO.setUsername("TFTPSYSAPPL");
        dbCredentialDTO.setPort(2288);
        dbCredentialDTO.setservicename("DOFTP");
        DBCredentialDTOList.add(dbCredentialDTO);
        for (DBCredentialDTO credentials : DBCredentialDTOList) {
            try {
                // Construct the Oracle database connection URL based on the provided credentials
                String databaseUrl = constructDatabaseUrl(credentials);
                System.out.println("ListDB: "+databaseUrl);

                // Attempt to connect to the database
                ResponseEntity<String> responseEntity = restTemplate.getForEntity(databaseUrl, String.class);

                // Add HttpStatus based on the response
                databaseStatusList.add((HttpStatus) responseEntity.getStatusCode());
                System.out.println("STATUS DB KA Cnnection: "+responseEntity.getStatusCode());
                System.out.println("STATUS LIST: "+databaseStatusList.size());
            } catch (RestClientException e) {
                // If an exception occurs, consider the database connection as down
                System.out.println("Error connecting to database: " + e.getMessage());
                databaseStatusList.add(HttpStatus.SERVICE_UNAVAILABLE);
            }
        }

        return databaseStatusList;
    }

    private String constructDatabaseUrl(DBCredentialDTO credentials) {
        // Construct the Oracle database connection URL based on the provided credentials
        // Modify this method according to your Oracle database connection details
        // Example: "jdbc:oracle:thin:@hostname:port:SID"
        return "jdbc:oracle:thin:@" + credentials.getHostname() + ":" + credentials.getPort() + ":" + credentials.getservicename();
    }

}    