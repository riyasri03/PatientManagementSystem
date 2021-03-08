package com.PatientManagementSearch.PatientSearch.repository;

import com.PatientManagementSearch.PatientSearch.entity.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

    Patient findByEmail(String email);

    @Query(value = "select name from patient where patient_id=?1", nativeQuery = true)
    String getPatientName(Integer patient);
}
