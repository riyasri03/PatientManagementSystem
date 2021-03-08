package com.PatientManagementSearch.PatientSearch.service.impl;

import com.PatientManagementSearch.PatientSearch.dto.NurseRequestDto;
import com.PatientManagementSearch.PatientSearch.dto.NurseResponseDto;
import com.PatientManagementSearch.PatientSearch.entity.Nurse;
import com.PatientManagementSearch.PatientSearch.repository.NurseRepository;
import com.PatientManagementSearch.PatientSearch.service.NurseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NurseServiceImpl implements NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    @Override
    public NurseResponseDto saveDetails(NurseRequestDto nurseRequestDto)
    {
        Nurse nurse = new Nurse();
        BeanUtils.copyProperties(nurseRequestDto, nurse);
        Nurse savedNurse = nurseRepository.save(nurse);
        NurseResponseDto nurseResponseDto = new NurseResponseDto();
        BeanUtils.copyProperties(savedNurse, nurseResponseDto);
        return nurseResponseDto;
    }
}
