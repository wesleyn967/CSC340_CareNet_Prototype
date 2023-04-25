package com.csc340sp23.CareNet.patient;

import com.csc340sp23.CareNet.patient.PatientInfo;
import com.csc340sp23.CareNet.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patientLoginPage")
    public String patientLogin(Model model) {
        model.addAttribute("patientInfo", new PatientInfo());
        return "patientLoginPage";
    }

    @PostMapping("/patientLoginPage")
    public String processLoginForm(@ModelAttribute("patientInfo") PatientInfo patientInfo) {
        boolean authenticated = patientService.authenticate(patientInfo.getUsername(), patientInfo.getPassword());
        if (authenticated && patientInfo.getUserType().equals("patient")) {
            return "redirect:/patientDashboard";
        } else {
            return "redirect:/patientDashboard";
        }
    }

    @GetMapping("/patientDashboard")
    public String showDashboardPage() {
        
        return "patientDashboard";
    }
    
    @GetMapping("/patientBill")
    public String showPatientBill(){
        
        return"patientBill";
    }
    
    @GetMapping("/patientResults")
    public String showPatientResults(){
        return "patientResults";
    }
    
    @GetMapping("/testing")
    public String testing(){
        return "testing";
    }
    
    @GetMapping("/patientAppointment")
    public String showPatientAppointment() {
        return "patientAppointment";
    }
    
    
    @GetMapping("/patientChat")
    public String patientChat(){
        return "patientChat";
    }

    @GetMapping("/patientProviderChat")
    public String patientProviderChat(){
        return "patientProviderChat";
    }
    
    @GetMapping("/patientAdminChat")
    public String patientAdminChat(){
        return "patientAdminChat";
    }
    
    @GetMapping("/patientPrescription")
    public String patientPrescription(){
        return "patientPrescription";
    }
}
