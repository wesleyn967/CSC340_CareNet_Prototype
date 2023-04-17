/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csc340sp23.CareNet.provider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class appointmentResults {
    private static final String URL = "jdbc:mysql://localhost:3306/appointment_results?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) {
        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");

            // Perform database operations
            // Insert data
            insertAppointment("John Doe", "2023-04-16 14:30:00", "Sample description", new byte[]{1, 2, 3}, connection);

            // Retrieve data
            retrieveAppointments(connection);

            // Close the database connection
            connection.close();
            System.out.println("Disconnected from the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertAppointment(String patientName, String date, String description, byte[] upload, Connection connection) throws SQLException {
        String sql = "INSERT INTO appointment_results (patientName, Date, Description, Upload) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, patientName);
        statement.setString(2, date);
        statement.setString(3, description);
        statement.setBytes(4, upload);
        statement.executeUpdate();
        System.out.println("Appointment inserted successfully.");
    }

    public static void retrieveAppointments(Connection connection) throws SQLException {
        String sql = "SELECT * FROM appointment_results";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("patientName");
            String date = resultSet.getString("Date");
            String description = resultSet.getString("Description");
            byte[] upload = resultSet.getBytes("Upload");
            System.out.println("patientName: " + name + ", Date: " + date + ", Description: " + description + ", Upload: " + new String(upload));
        }
        resultSet.close();
        statement.close();
    }
}