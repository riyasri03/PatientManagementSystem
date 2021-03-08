package com.PatientManagementSearch.PatientSearch.dto;

import lombok.Data;

@Data
public class PatientRequestDto {

    private int patientId;
    private String name;
    private String email;
    private String password;
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
