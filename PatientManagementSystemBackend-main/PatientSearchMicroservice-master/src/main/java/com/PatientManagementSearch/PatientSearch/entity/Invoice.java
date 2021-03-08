package com.PatientManagementSearch.PatientSearch.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "invoiceSearch")
@Data
public class Invoice {

    @Id
    @GenericGenerator(name = "invoice_id_seq", strategy = "increment")
    @GeneratedValue(generator = "invoice_id_seq", strategy = GenerationType.AUTO)
    private int invoiceId;
    private int patientId;
    private int doctorId;
    private String issue;
    private String patientName;
    private String doctorName;
    private boolean isFirstTime;
    private boolean isTreated;
}
