package com.PatientManagementSearch.PatientSearch.dto;

import lombok.Data;

@Data
public class DoctorRequestDto {

    private int doctorId;
    private String doctorName;
    private String doctorEmail;
    private String doctorPassword;
    private Long doctorContact;
    private int nurseId;
}
