package com.PatientManagementSearch.PatientSearch.service;

import com.PatientManagementSearch.PatientSearch.dto.DoctorRequestDto;
import com.PatientManagementSearch.PatientSearch.dto.DoctorResponseDto;
import com.PatientManagementSearch.PatientSearch.dto.HistoryRequestDto;

public interface DoctorService {

    DoctorResponseDto saveDetails(DoctorRequestDto doctorRequestDto);
    DoctorResponseDto updateDoctor(int doctorId);
    void endConsultation(HistoryRequestDto historyRequestDto);
}
