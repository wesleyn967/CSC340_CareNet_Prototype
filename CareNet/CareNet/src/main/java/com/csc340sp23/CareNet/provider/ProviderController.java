package com.csc340sp23.CareNet.provider;

import com.csc340sp23.CareNet.provider.ProviderInfo;
import com.csc340sp23.CareNet.provider.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.time.LocalDate;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/providerLoginPage")
    public String providerLogin(Model model) {
        model.addAttribute("providerInfo", new ProviderInfo());
        return "providerLoginPage";
    }

    @GetMapping("/providerLoginPageRetry")
    public String providerLoginRetry(Model model) {
        return "providerLoginPageRetry";
    }

    @PostMapping("/providerLoginPage")
    public String processLoginForm(@ModelAttribute("providerInfo") ProviderInfo providerInfo) {
        boolean authenticated = providerService.authenticate(providerInfo.getUsername(), providerInfo.getPassword());
        if (authenticated && providerInfo.getUserType().equals("provider")) {
            return "redirect:/providerDashboard";
        } else {
            return "redirect:/providerLoginPageRetry";
        }
    }

    @GetMapping("/providerDashboard")
    public String showDashboardPage() {

        return "providerDashboard";
    }

    @GetMapping("/providerAppointment")
    public String showAppointmentPage(Model model) {
        model.addAttribute("providerInfo", new ProviderInfo());
        return "providerAppointment";
    }

    @GetMapping("/providerChat")
    public String showProviderChat() {

        return "providerChat";
    }

    @GetMapping("/providerPatientChat")
    public String showProviderPatientChat() {

        return "providerPatientChat";
    }

    @GetMapping("/providerAdminChat")
    public String showProviderAdminChat() {

        return "providerAdminChat";
    }

    @GetMapping("/providerPrescriptionRefill")
    public String showProviderPrescriptionRefill() {

        return "providerPrescriptionRefill";
    }

    @GetMapping("/providerResults")
    public String showProviderResults(Model model) {
        model.addAttribute("resultInfo", new ResultInfo());
        return "providerResults";
    }

    @PostMapping("/providerResults")
    public String processProviderResultsForm(@ModelAttribute("resultInfo") ResultInfo resultInfo) {
        // Extract the data from the AppointmentInfo object
        String patientName = resultInfo.getPatientName();
        Date date = resultInfo.getDate();
        String description = resultInfo.getDescription();
        MultipartFile upload = resultInfo.getUpload();

        // Perform necessary processing on the uploaded file, e.g., save to disk or store in database

        // Create an AppointmentData object with the extracted data
        ResultData appointmentData = new ResultData(patientName, date, description, upload);

        // Call the AppointmentService to process and store the AppointmentData object in the database
        providerService.processProviderResultsForm(appointmentData);

        // Redirect to a success page or return an appropriate response
        return "redirect:/successPage";
    }
    
    @GetMapping("/successPage")
    public String successResultsPage() {

        return "successPage";
    }

}
