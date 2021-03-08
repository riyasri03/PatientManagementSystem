package com.PatientManagementSearch.PatientSearch.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "doctorSearch")
@Data
public class Doctor {

    @Id
    @GenericGenerator(name = "doctor_id_seq", strategy = "increment")
    @GeneratedValue(generator = "doctor_id_seq", strategy = GenerationType.AUTO)
    private int doctorId;
    private String doctorName;
    @Column(unique = true)
    private String doctorEmail;
    private String doctorPassword;
    private int doctorPatientCount;
    private Long doctorContact;
    @OneToOne
    @JoinColumn(name = "nurseId")
    private Nurse nurse;
}
