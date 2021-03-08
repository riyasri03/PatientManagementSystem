package com.PatientManagementSearch.PatientSearch.service;

import com.PatientManagementSearch.PatientSearch.dto.NurseRequestDto;
import com.PatientManagementSearch.PatientSearch.dto.NurseResponseDto;

public interface NurseService {

    NurseResponseDto saveDetails(NurseRequestDto nurseRequestDto);
}
