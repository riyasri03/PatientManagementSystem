package com.PatientManagementSearch.PatientSearch.dto;

import lombok.Data;

@Data
public class HistoryRequestDto {

    private int doctorId;
    private int patientId;
    private String month;
}
