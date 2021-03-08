package com.PatientManagementSearch.PatientSearch.controller;

import com.PatientManagementSearch.PatientSearch.dto.InvoiceRequestDto;
import com.PatientManagementSearch.PatientSearch.dto.InvoiceResponseDto;
import com.PatientManagementSearch.PatientSearch.dto.PatientRequestDto;
import com.PatientManagementSearch.PatientSearch.dto.PatientResponseDto;
import com.PatientManagementSearch.PatientSearch.service.InvoiceService;
import com.PatientManagementSearch.PatientSearch.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/patient")
@CrossOrigin("*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private InvoiceService invoiceService;


    @PostMapping(value = "/registration")
    public PatientResponseDto saveDetails(@RequestBody PatientRequestDto patientRequestDto) {
        return patientService.saveDetails(patientRequestDto);
    }

    @PutMapping("/makePayment/{patientId}")
    public InvoiceResponseDto makePaymentAndBookDoctor(@PathVariable("patientId") int patientId, @RequestBody InvoiceRequestDto invoiceRequestDto) {
        return invoiceService.makePaymentAndBookDoctor(patientId, invoiceRequestDto);
    }
}
