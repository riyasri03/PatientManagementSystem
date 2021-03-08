package com.PatientManagementSearch.PatientSearch.service;

import com.PatientManagementSearch.PatientSearch.dto.PatientRequestDto;
import com.PatientManagementSearch.PatientSearch.dto.PatientResponseDto;

public interface PatientService {

    PatientResponseDto saveDetails(PatientRequestDto patientRequestDto);
}
