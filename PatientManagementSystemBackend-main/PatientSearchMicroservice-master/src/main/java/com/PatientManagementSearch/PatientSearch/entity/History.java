package com.PatientManagementSearch.PatientSearch.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "historySearch")
@Document(indexName = "test3")
@Data
public class History {

    @Id
    @org.springframework.data.annotation.Id
    @GenericGenerator(name = "history_id_seq", strategy = "increment")
    @GeneratedValue(generator = "history_id_seq", strategy = GenerationType.AUTO)
    private int historyId;
    private int patientId;
    private int doctorId;
    private String patientName;
    private String doctorName;
    private String month;
    private String issue;
}
