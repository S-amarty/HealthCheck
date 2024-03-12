package com.eaiftpHealthCheck.serviceImpl;

import com.eaiftpHealthCheck.dto.SchedulerDetailDTO;
import com.eaiftpHealthCheck.service.PDFGenerationService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PDFGenerationServiceImpl implements PDFGenerationService {

    @Override
    public ByteArrayInputStream generatePDF(List<SchedulerDetailDTO> schedulerDetails, String environmentType) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, out);

            document.open(); 

            PdfPTable table = new PdfPTable(7);
            
            table.setWidthPercentage(100); // Set the table width to 100% of the page width

            float[] columnWidths = {2f, 2f, 2f, 2f, 2f, 2f, 2f}; // Adjust the widths as needed
            table.setWidths(columnWidths);
            addTableHeader(table);

            List<SchedulerDetailDTO> filteredList = filterByEnvironmentType(schedulerDetails, environmentType);
            addRows(table, filteredList);

            document.add(table);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

    private List<SchedulerDetailDTO> filterByEnvironmentType(List<SchedulerDetailDTO> schedulerDetails, String environmentType) {
        return schedulerDetails.stream()
                .filter(detail -> environmentType.equalsIgnoreCase(detail.getEnvironment_name()))
                .collect(Collectors.toList());
    }

    private void addTableHeader(PdfPTable table) {
        table.addCell("ID");
        table.addCell("Application ID");
        table.addCell("Environment Name");
        table.addCell("Application Type");
        table.addCell("URL");
        table.addCell("Status");
        table.addCell("TimeStamp");
    }

    private void addRows(PdfPTable table, List<SchedulerDetailDTO> schedulerDetails) {
        for (SchedulerDetailDTO schedulerDetail : schedulerDetails) {
            table.addCell(String.valueOf(schedulerDetail.getId()));
            table.addCell(String.valueOf(schedulerDetail.getApplication_id()));
            table.addCell(schedulerDetail.getEnvironment_name());
            table.addCell(schedulerDetail.getApplication_type());
            table.addCell(schedulerDetail.getUrl());
            table.addCell(String.valueOf(schedulerDetail.getStatus()));
            table.addCell(schedulerDetail.getTimestamp());
        }
    }

}
