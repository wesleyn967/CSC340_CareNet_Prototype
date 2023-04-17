package com.csc340sp23.CareNet.provider;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "appointment_results") // Replace with your actual table name
public class ResultData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_name")
    private String patientName;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String description;

    // Constructors
    public ResultData() {
        // Default constructor
    }

    public ResultData(String patientName, Date date, String description) {
        this.patientName = patientName;
        this.date = date;
        this.description = description;
    }

    // Getters and Setters

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
