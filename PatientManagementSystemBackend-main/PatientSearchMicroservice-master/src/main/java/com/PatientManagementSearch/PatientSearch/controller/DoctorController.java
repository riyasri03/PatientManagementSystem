package com.PatientManagementSearch.PatientSearch.controller;

import com.PatientManagementSearch.PatientSearch.dto.DoctorRequestDto;
import com.PatientManagementSearch.PatientSearch.dto.DoctorResponseDto;
import com.PatientManagementSearch.PatientSearch.dto.HistoryRequestDto;
import com.PatientManagementSearch.PatientSearch.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/doctor")
@CrossOrigin("*")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping(value = "/")
    public DoctorResponseDto saveDetails(@RequestBody DoctorRequestDto doctorRequestDto)
    {
        return doctorService.saveDetails(doctorRequestDto);
    }


    @PutMapping("/endConsultation")
    public void endConsultation(@RequestBody HistoryRequestDto historyRequestDto) {
        doctorService.endConsultation(historyRequestDto);
    }
}
