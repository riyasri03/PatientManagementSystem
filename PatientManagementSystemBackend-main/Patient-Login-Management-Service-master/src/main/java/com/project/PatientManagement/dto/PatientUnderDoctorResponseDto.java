package com.project.PatientManagement.dto;

import lombok.Data;

@Data
public class PatientUnderDoctorResponseDto {

    private int id;
    private String patientName;
    private long patientContact;
    private String gender;
    private int age;
    private String issue;
}
