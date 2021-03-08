package com.PatientManagementSearch.PatientSearch.dto;

import lombok.Data;

@Data
public class PatientResponseDto {

    private int patientId;
    private String name;
    private String email;
    private String gender;
    private Integer age;
    private String address;
    private Double height;
    private Double weight;
    private String currentMedication;
    private Long contact;
    private Long emergencyContact;
    private String admissionMonth;
}
