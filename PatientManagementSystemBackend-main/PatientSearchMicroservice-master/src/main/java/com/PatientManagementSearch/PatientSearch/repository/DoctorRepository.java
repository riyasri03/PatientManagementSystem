package com.PatientManagementSearch.PatientSearch.repository;

import com.PatientManagementSearch.PatientSearch.entity.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

    @Query(value = "select doctor_name from doctor where doctor_id=?1", nativeQuery = true)
    String getDoctorName(int doctorId);
}
