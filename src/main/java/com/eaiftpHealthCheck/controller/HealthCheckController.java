package com.eaiftpHealthCheck.controller;

import com.eaiftpHealthCheck.dto.ApplicationDetailDTO;
import com.eaiftpHealthCheck.dto.SchedulerDetailDTO;
import com.eaiftpHealthCheck.service.HealthCheckService;
import com.eaiftpHealthCheck.service.PDFGenerationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;

@Controller
public class HealthCheckController {

    private final HealthCheckService healthCheckService;
    private final PDFGenerationService pdfGenerationService;

    public HealthCheckController(HealthCheckService healthCheckService, PDFGenerationService pdfGenerationService) {
        this.healthCheckService = healthCheckService;
        this.pdfGenerationService = pdfGenerationService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        Map<Integer, String> applicationMap = healthCheckService.getApplicationMap();
     //   List<HttpStatus> statusCodeList = healthCheckService.checkMultipleDatabaseConnections();
        model.addAttribute("applicationMap", applicationMap);
        return "home";
    }

    @GetMapping("/healthCheck")
    public String getHealthChecks(Model model) {
        List<HttpStatus> statusCodeList = healthCheckService.getHttpStatus(1);
        List<ApplicationDetailDTO> applicationDetailDTOList = healthCheckService.getApplicationList(1);
        Map<Integer, String> applicationMap = healthCheckService.getApplicationMap();
        model.addAttribute("applicationMap", applicationMap);
        model.addAttribute("statusCodeList", statusCodeList);
        model.addAttribute("applicationDetailDTOList", applicationDetailDTOList);
        return "healthCheck";
    }

    @SuppressWarnings("null")
    @GetMapping("/downloadReport/{environmentType}")
    public ResponseEntity<byte[]> downloadReport(@PathVariable String environmentType) {
        try {
            List<SchedulerDetailDTO> schedulerDetails = healthCheckService.getAllSchedulerDetails();
            ByteArrayInputStream pdfBytes = pdfGenerationService.generatePDF(schedulerDetails, environmentType);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "inline; filename=report.pdf")
                    .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                    .body(pdfBytes.readAllBytes());
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
