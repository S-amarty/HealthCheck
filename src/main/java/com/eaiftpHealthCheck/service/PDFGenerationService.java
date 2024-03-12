package com.eaiftpHealthCheck.service;

import com.eaiftpHealthCheck.dto.SchedulerDetailDTO;

import java.util.List;
import java.io.ByteArrayInputStream;

public interface PDFGenerationService {
    ByteArrayInputStream generatePDF(List<SchedulerDetailDTO> schedulerDetails, String environmentType);

 
}
