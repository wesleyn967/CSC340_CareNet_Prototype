package com.csc340sp23.CareNet.admin;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    // This map simulates a database of admin credentials
    private static final Map<String, String> ADMIN_CREDENTIALS = new HashMap<>();

    static {
        ADMIN_CREDENTIALS.put("admin", "admin");
    }

    public boolean authenticate(String username, String password) {
        String expectedPassword = ADMIN_CREDENTIALS.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }

}
