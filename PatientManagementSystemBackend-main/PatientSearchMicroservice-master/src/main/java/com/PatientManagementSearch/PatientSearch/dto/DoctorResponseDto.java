package com.PatientManagementSearch.PatientSearch.dto;

import com.PatientManagementSearch.PatientSearch.entity.Nurse;
import lombok.Data;

@Data
public class DoctorResponseDto {

    private int doctorId;
    private String doctorName;
    private String doctorEmail;
    private Long doctorContact;
    private Nurse nurse;
}
