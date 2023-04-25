package com.csc340sp23.CareNet.provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class appointmentResults {
    public void processResults(ResultData resultData) {
        // Extract the data from the ResultData object
        String patientName = resultData.getPatientName();
        Date date = resultData.getDate();
        String description = resultData.getDescription();

        // Store the extracted data in a database or perform any other necessary processing
        // Example code to store data in a database
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/appointment_results?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");

            // Create and execute SQL query to insert data into results table
            String query = "INSERT INTO appointment_results (patientName, date, description) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, patientName);
            statement.setDate(2, new java.sql.Date(date.getTime()));
            statement.setString(3, description);
            statement.executeUpdate();

            // Close database resources
            statement.close();
            conn.close();
        } catch (SQLException e) {
            // Handle exception appropriately
        }
    }

    public static void insertAppointment(String patientName, String date, String description, Connection connection) throws SQLException {
        String sql = "INSERT INTO appointment_results (patientName, Date, Description) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, patientName);
        statement.setString(2, date);
        statement.setString(3, description);
        statement.executeUpdate();
        System.out.println("Appointment inserted successfully.");
        statement.close();
        connection.commit(); // Commit the transaction
    }

    public static void retrieveAppointments(Connection connection) throws SQLException {
        String sql = "SELECT * FROM `appointment_results`";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("patientName");
            String date = resultSet.getString("Date");
            String description = resultSet.getString("Description");
            System.out.println("patientName: " + name + ", Date: " + date + ", Description: " + description);
        }
        resultSet.close();
        statement.close();
    }
}
