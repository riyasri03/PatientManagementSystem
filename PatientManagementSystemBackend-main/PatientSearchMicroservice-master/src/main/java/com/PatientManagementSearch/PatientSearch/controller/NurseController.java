package com.PatientManagementSearch.PatientSearch.controller;

import com.PatientManagementSearch.PatientSearch.dto.NurseRequestDto;
import com.PatientManagementSearch.PatientSearch.dto.NurseResponseDto;
import com.PatientManagementSearch.PatientSearch.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/nurse")
@CrossOrigin("*")
public class NurseController {

    @Autowired
    private NurseService nurseService;

    @PostMapping(value = "/")
    public NurseResponseDto saveDetails(@RequestBody NurseRequestDto nurseRequestDto)
    {
        return nurseService.saveDetails(nurseRequestDto);
    }
}
