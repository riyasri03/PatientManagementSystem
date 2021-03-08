package com.PatientManagementSearch.PatientSearch.dto;

import lombok.Data;

@Data
public class NurseRequestDto {

    private int nurseId;
    private String nurseName;
    private String nurseEmail;
    private String nursePassword;
    private Long nurseContact;
}
