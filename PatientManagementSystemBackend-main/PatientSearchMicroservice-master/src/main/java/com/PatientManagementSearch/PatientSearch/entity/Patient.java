package com.PatientManagementSearch.PatientSearch.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "patientSearch")
@Data
public class Patient {

    @Id
    @org.springframework.data.annotation.Id
    @GenericGenerator(name = "patient_id_seq", strategy = "increment")
    @GeneratedValue(generator = "patient_id_seq", strategy = GenerationType.AUTO)
    private int patientId;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String gender;
    private Integer age;
    private String address;
    private Double height;
    private Double weight;
    private String currentMedication;
    private Long contact;
    private Long emergencyContact;
    private String admissionMonth;
}
