package com.csc340sp23.CareNet.provider;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProviderService {

    // This map simulates a database of provider credentials
    private static final Map<String, String> PROVIDER_CREDENTIALS = new HashMap<>();

    static {
        PROVIDER_CREDENTIALS.put("provider", "provider");
    }

    public boolean authenticate(String username, String password) {
        String expectedPassword = PROVIDER_CREDENTIALS.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }

    public void processResults(ResultData resultData) {
        // Extract the data from the ResultData object
        String patientName = resultData.getPatientName();
        Date date = resultData.getDate();
        String description = resultData.getDescription();
        MultipartFile upload = resultData.getUpload();
        String filePath = null;

        // Perform necessary processing on the uploaded file, e.g., save to disk or store in database
        // Example code to save the uploaded file to disk
        // Perform necessary processing on the uploaded file, e.g., save to disk or store in database
        // Example code to save the uploaded file to disk
        try {
            String fileName = upload.getOriginalFilename();
            filePath = "/path/to/save/results/" + fileName;
            upload.transferTo(new File(filePath));
            // Perform any other necessary processing on the results data
            // ...
        } catch (IOException e) {
            // Handle exception appropriately
        }

        // Store the extracted data in a database or perform any other necessary processing
        // Example code to store data in a database
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_results", "root", "pass");

            // Create and execute SQL query to insert data into results table
            String query = "INSERT INTO results (patientName, date, description, file_path) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, patientName);
            statement.setDate(2, new java.sql.Date(date.getTime()));
            statement.setString(3, description);
            statement.setString(4, filePath);
            statement.executeUpdate();

            // Close database resources
            statement.close();
            conn.close();
        } catch (SQLException e) {
            // Handle exception appropriately
        }
    }

    void processProviderResultsForm(ResultData appointmentData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
