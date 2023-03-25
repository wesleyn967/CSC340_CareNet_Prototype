package com.csc340sp23.CareNet.patient;

import com.csc340sp23.CareNet.patient.*;
import com.csc340sp23.CareNet.patient.PatientInfo;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    // This map simulates a database of provider credentials
    private static final Map<String, String> PROVIDER_CREDENTIALS = new HashMap<>();

    static {
        PROVIDER_CREDENTIALS.put("alice", "password123");
        PROVIDER_CREDENTIALS.put("bob", "letmein");
    }

    public boolean authenticate(String username, String password) {
        String expectedPassword = PROVIDER_CREDENTIALS.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }

}
