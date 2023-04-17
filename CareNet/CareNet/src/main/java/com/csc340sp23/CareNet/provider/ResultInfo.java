package com.csc340sp23.CareNet.provider;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile; // Import MultipartFile from Spring

public class ResultInfo {

    private String patientName;
    private Date date;
    private String description;
    private MultipartFile upload; // Add field for upload file

    // Constructors
    public ResultInfo() {
    }

    public ResultInfo(String patientName, Date date, String description, MultipartFile upload) {
        this.patientName = patientName;
        this.date = date;
        this.description = description;
        this.upload = upload;
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

    public MultipartFile getUpload() {
        return upload;
    }

    public void setUpload(MultipartFile upload) {
        this.upload = upload;
    }
}
