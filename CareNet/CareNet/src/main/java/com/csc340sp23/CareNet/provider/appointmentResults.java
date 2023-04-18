package com.csc340sp23.CareNet.provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentResults {
    private static final String URL = "jdbc:mysql://localhost:3306/appointment_results?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Establish database connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");

            // Retrieve data
            retrieveAppointments(connection);

            // Close the database connection
            connection.close();
            System.out.println("Disconnected from the database.");
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing database connection: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void insertAppointment(String patientName, String date, String description, Connection connection) throws SQLException {
        String sql = "INSERT INTO appointment_results (patientName, Date, Description, Upload) VALUES (?, ?, ?, ?)";
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
