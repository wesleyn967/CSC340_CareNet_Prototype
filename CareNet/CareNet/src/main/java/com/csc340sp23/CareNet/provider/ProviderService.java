package com.csc340sp23.CareNet.provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

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

    void processResults(ResultData resultData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void sendDataToDatabase(String username, String password, String data) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // Create a connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name", username, password);

            // Prepare a statement to insert data into a table
            statement = connection.prepareStatement("INSERT INTO table_name (data) VALUES (?)");
            statement.setString(1, data);

            // Execute the statement
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String retrieveDataFromDatabase(String username, String password) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String result = null;
        try {
            // Create a connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_name", username, password);

            // Create a statement to retrieve data from a table
            statement = connection.createStatement();
            String query = "SELECT * FROM table_name";

            // Execute the query and retrieve the results
            resultSet = statement.executeQuery(query);

            // Extract the data from the result set
            while (resultSet.next()) {
                result = resultSet.getString("data");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the result set, statement, and connection
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
