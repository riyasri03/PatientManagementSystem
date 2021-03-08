package com.PatientManagementSearch.PatientSearch.service.impl;

import com.PatientManagementSearch.PatientSearch.dto.PatientRequestDto;
import com.PatientManagementSearch.PatientSearch.dto.PatientResponseDto;
import com.PatientManagementSearch.PatientSearch.entity.Patient;
import com.PatientManagementSearch.PatientSearch.repository.PatientRepository;
import com.PatientManagementSearch.PatientSearch.service.PatientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public PatientResponseDto saveDetails(PatientRequestDto patientRequestDto)
    {
        Patient patient = new Patient();
        Optional<Patient> optionalPatient = Optional.ofNullable(patientRepository.findByEmail(patientRequestDto.getEmail()));
        if(optionalPatient.isPresent())
        {
            return null;
        }
        BeanUtils.copyProperties(patientRequestDto, patient);
        Patient savedPatient = patientRepository.save(patient);
        PatientResponseDto patientResponseDto = new PatientResponseDto();
        BeanUtils.copyProperties(savedPatient, patientResponseDto);
        return patientResponseDto;
    }
}
