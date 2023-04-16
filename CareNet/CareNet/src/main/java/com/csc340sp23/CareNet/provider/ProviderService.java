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
    
    

}
