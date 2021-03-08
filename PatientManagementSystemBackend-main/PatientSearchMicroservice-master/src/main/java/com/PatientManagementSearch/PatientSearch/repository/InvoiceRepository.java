package com.PatientManagementSearch.PatientSearch.repository;

import com.PatientManagementSearch.PatientSearch.entity.Invoice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer> {

    @Query(value = "update invoice set doctor_id=?1, issue=?2 where patient_id=?3", nativeQuery = true)
    void setInvoiceTable(int doctorId, String issue, int patientId);

    @Query(value = "select * from invoice where patient_id=?1", nativeQuery = true)
    Invoice getInvoiceByPatientId(int patientId);

    @Query(value = "select is_treated from invoice where patient_id=?1", nativeQuery = true)
    boolean isTreated(int patientId);

    @Query(value = "select * from invoice where patient_id=?1", nativeQuery = true)
    Invoice findByPatientId(int patientId);

    @Query(value = "select issue from invoice where patient_id=?1", nativeQuery = true)
    String getPatientIssue(Integer patient);

    @Modifying
    @Query(value = "delete from invoice where patient_id=?1", nativeQuery = true)
    void deleteByPatientId(int patientId);
}
