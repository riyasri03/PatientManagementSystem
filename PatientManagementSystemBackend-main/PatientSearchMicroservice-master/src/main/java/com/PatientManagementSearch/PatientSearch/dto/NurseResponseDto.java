package com.PatientManagementSearch.PatientSearch.dto;

import lombok.Data;

@Data
public class NurseResponseDto {

    private int nurseId;
    private String nurseName;
    private String nurseEmail;
    private Long nurseContact;
}
