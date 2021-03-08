package com.PatientManagementSearch.PatientSearch.dto;

import lombok.Data;

@Data
public class InvoiceResponseDto {

    private int doctorId;
    private String doctorName;
    private long doctorContact;
    private boolean isTreated;
    private boolean isFirstTime;
}
