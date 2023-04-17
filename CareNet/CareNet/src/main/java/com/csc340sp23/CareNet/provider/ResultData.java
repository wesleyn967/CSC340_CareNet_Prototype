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
    private Long id; // Example primary key field, use appropriate data type

    @Column(name = "patient_name")
    private String patientName;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String description;

    @Transient // Ignore this field when persisting to the database
    private MultipartFile upload;

    // Constructors
    public ResultData() {
        // Default constructor
    }

    public ResultData(Long id, String patientName, Date date, String description, MultipartFile upload) {
        this.id = id;
        this.patientName = patientName;
        this.date = date;
        this.description = description;
        this.upload = upload;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    
    public MultipartFile getUpload(){
        return upload;
    }

    public void setUpload(MultipartFile upload){
        this.upload = upload;
    }

    // Additional methods to convert data from ResultInfo object
    public static ResultData fromResultInfo(ResultInfo resultInfo) {
        return new ResultData(resultInfo.getId(), resultInfo.getPatientName(), resultInfo.getDate(), resultInfo.getDescription(), resultInfo.getUpload());
    }
}
