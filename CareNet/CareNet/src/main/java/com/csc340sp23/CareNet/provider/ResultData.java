package com.csc340sp23.CareNet.provider;

import com.csc340sp23.CareNet.provider.ResultInfo;
import java.util.Date;

public class ResultData {
    private String patientName;
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

    // Additional methods to convert data from ResultInfo object
    public static ResultData fromResultInfo(ResultInfo resultInfo) {
        return new ResultData(resultInfo.getPatientName(), resultInfo.getDate(), resultInfo.getDescription());
    }
}