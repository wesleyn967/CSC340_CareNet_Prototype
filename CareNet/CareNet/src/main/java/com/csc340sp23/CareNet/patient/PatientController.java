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

    @GetMapping("/patientLogin")
    public String patientLogin(Model model) {
        model.addAttribute("patientInfo", new PatientInfo());
        return "patientLogin";
    }

    @PostMapping("/patientLogin")
    public String processLoginForm(@ModelAttribute("patientInfo") PatientInfo patientInfo) {
        boolean authenticated = patientService.authenticate(patientInfo.getUser(), patientInfo.getPass());
        if (authenticated) {
            return "redirect:/dashboard";
        } else {
            return "redirect:/patientLogin?error";
        }
    }

    @GetMapping("/patientLogin/dashboard")
    public String showDashboardPage() {
        return "/patientLogin/dashboard";
    }

}
