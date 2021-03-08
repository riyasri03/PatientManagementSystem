package com.PatientManagementSearch.PatientSearch.service.impl;

import com.PatientManagementSearch.PatientSearch.dto.DoctorRequestDto;
import com.PatientManagementSearch.PatientSearch.dto.DoctorResponseDto;
import com.PatientManagementSearch.PatientSearch.dto.HistoryRequestDto;
import com.PatientManagementSearch.PatientSearch.entity.Doctor;
import com.PatientManagementSearch.PatientSearch.entity.History;
import com.PatientManagementSearch.PatientSearch.entity.Nurse;
import com.PatientManagementSearch.PatientSearch.repository.*;
import com.PatientManagementSearch.PatientSearch.service.DoctorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private NurseRepository nurseRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public DoctorResponseDto saveDetails(DoctorRequestDto doctorRequestDto)
    {
        Doctor doctor = new Doctor();
        BeanUtils.copyProperties(doctorRequestDto, doctor);
        Optional<Nurse> optionalNurse = nurseRepository.findById(doctorRequestDto.getNurseId());
        Nurse nurse = null;
        if(optionalNurse.isPresent())
        {
            nurse = optionalNurse.get();
        }
        doctor.setNurse(nurse);
        Doctor savedDoctor = doctorRepository.save(doctor);
        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();
        BeanUtils.copyProperties(savedDoctor, doctorResponseDto);
        return doctorResponseDto;
    }

    @Override
    public DoctorResponseDto updateDoctor(int doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).get();
        int doctorPatientCount = doctor.getDoctorPatientCount();
        if(doctorPatientCount == 5) {
            return null;
        }

        doctorPatientCount = doctorPatientCount + 1;
        doctor.setDoctorPatientCount(doctorPatientCount);
        Doctor savedDoctor = doctorRepository.save(doctor);
        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();
        BeanUtils.copyProperties(savedDoctor, doctorResponseDto);
        return doctorResponseDto;
    }

    @Override
    public void endConsultation(HistoryRequestDto historyRequestDto) {

        int patientId = historyRequestDto.getPatientId();
        int doctorId = historyRequestDto.getDoctorId();
        String month = historyRequestDto.getMonth();
        Doctor doctor = doctorRepository.findById(doctorId).get();
        int doctorPatientCount = doctor.getDoctorPatientCount();
        doctorPatientCount = doctorPatientCount - 1;
        doctor.setDoctorPatientCount(doctorPatientCount);
        doctorRepository.save(doctor);

        String doctorName = doctorRepository.getDoctorName(doctorId);
        String patientName = patientRepository.getPatientName(patientId);
        String issue = invoiceRepository.getPatientIssue(patientId);

        History history = new History();
        history.setDoctorId(doctorId);
        history.setDoctorName(doctorName);
        history.setPatientId(patientId);
        history.setPatientName(patientName);
        history.setMonth(month);
        history.setIssue(issue);

        historyRepository.save(history);

        invoiceRepository.deleteByPatientId(patientId);
    }
}
