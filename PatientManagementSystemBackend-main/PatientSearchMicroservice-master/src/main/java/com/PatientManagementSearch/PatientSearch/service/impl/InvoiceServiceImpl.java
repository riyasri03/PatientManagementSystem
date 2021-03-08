package com.PatientManagementSearch.PatientSearch.service.impl;

import com.PatientManagementSearch.PatientSearch.dto.DoctorResponseDto;
import com.PatientManagementSearch.PatientSearch.dto.InvoiceRequestDto;
import com.PatientManagementSearch.PatientSearch.dto.InvoiceResponseDto;
import com.PatientManagementSearch.PatientSearch.entity.Invoice;
import com.PatientManagementSearch.PatientSearch.repository.InvoiceRepository;
import com.PatientManagementSearch.PatientSearch.service.DoctorService;
import com.PatientManagementSearch.PatientSearch.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private DoctorService doctorService;

    @Override
    public InvoiceResponseDto makePaymentAndBookDoctor(int patientId, InvoiceRequestDto invoiceRequestDto) {

        Invoice invoice = invoiceRepository.getInvoiceByPatientId(patientId);
        InvoiceResponseDto invoiceResponseDto = new InvoiceResponseDto();

        if(invoice == null) {
            Invoice invoice1 = new Invoice();
            invoice1.setIssue(invoiceRequestDto.getIssue());
            invoice1.setPatientId(patientId);
            invoice1.setDoctorId(invoiceRequestDto.getDoctorId());
            invoice1.setTreated(false);
            invoice1.setFirstTime(true);
            invoice1.setDoctorName(invoiceRequestDto.getDoctorName());
            invoice1.setPatientName(invoiceRequestDto.getPatientName());

            invoiceRepository.save(invoice1);
        }

        else {
            boolean isTreated = invoiceRepository.isTreated(patientId);
            if(!isTreated)
                return null;
            invoiceRepository.setInvoiceTable(patientId, invoiceRequestDto.getIssue(), invoiceRequestDto.getDoctorId());
            invoiceResponseDto.setTreated(false);
        }
        DoctorResponseDto doctorResponseDto = doctorService.updateDoctor(invoiceRequestDto.getDoctorId());

        invoiceResponseDto.setDoctorId(doctorResponseDto.getDoctorId());
        invoiceResponseDto.setDoctorName(doctorResponseDto.getDoctorName());
        invoiceResponseDto.setDoctorContact(doctorResponseDto.getDoctorContact());


        return invoiceResponseDto;
    }
}
