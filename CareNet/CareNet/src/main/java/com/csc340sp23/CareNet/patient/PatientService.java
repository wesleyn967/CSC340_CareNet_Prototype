package com.csc340sp23.CareNet.patient;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    // This map simulates a database of provider credentials
    private static final Map<String, String> PATIENT_CREDENTIALS = new HashMap<>();

    static {
        PATIENT_CREDENTIALS.put("patient", "patient");
    }

    public boolean authenticate(String username, String password) {
        String expectedPassword = PATIENT_CREDENTIALS.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }

}
