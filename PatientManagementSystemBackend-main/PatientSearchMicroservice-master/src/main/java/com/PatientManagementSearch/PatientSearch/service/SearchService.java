package com.PatientManagementSearch.PatientSearch.service;

import com.PatientManagementSearch.PatientSearch.entity.History;

import java.util.List;

public interface SearchService {

    List<History> getPatientRecordFromHistory(String text);
    History save(History history);
    List<History> findAll();
}
