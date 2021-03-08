package com.PatientManagementSearch.PatientSearch.dto;

import lombok.Data;

@Data
public class InvoiceRequestDto {

    private int doctorId;
    private String patientName;
    private String doctorName;
    private String issue;
}
