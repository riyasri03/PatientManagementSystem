package com.PatientManagementSearch.PatientSearch.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "nurseSearch")
@Data
public class Nurse {

    @Id
    @GenericGenerator(name = "nurse_id_seq", strategy = "increment")
    @GeneratedValue(generator = "nurse_id_seq", strategy = GenerationType.AUTO)
    private int nurseId;
    private String nurseName;
    @Column(unique = true)
    private String nurseEmail;
    private String nursePassword;
    private Long nurseContact;
}
