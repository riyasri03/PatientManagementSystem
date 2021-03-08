package com.PatientManagementSearch.PatientSearch.service;

import com.PatientManagementSearch.PatientSearch.dto.InvoiceRequestDto;
import com.PatientManagementSearch.PatientSearch.dto.InvoiceResponseDto;

public interface InvoiceService {

    InvoiceResponseDto makePaymentAndBookDoctor(int patientId, InvoiceRequestDto invoiceRequestDto);
}
