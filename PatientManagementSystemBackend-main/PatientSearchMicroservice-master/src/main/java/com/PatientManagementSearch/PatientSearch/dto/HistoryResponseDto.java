package com.PatientManagementSearch.PatientSearch.dto;

import lombok.Data;

@Data
public class HistoryResponseDto {

    private int historyId;
    private int patientId;
    private int doctorId;
    private String patientName;
    private String doctorName;
    private String month;
    private String issue;
}
