package com.csc340sp23.CareNet.provider;

import com.csc340sp23.CareNet.provider.*;
import com.csc340sp23.CareNet.provider.ProviderInfo;
import com.csc340sp23.CareNet.provider.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping("/providerLoginPage")
    public String providerLogin(Model model) {
        model.addAttribute("providerInfo", new ProviderInfo());
        return "providerLoginPage";
    }

    @PostMapping("/providerLoginPage")
    public String processLoginForm(@ModelAttribute("providerInfo") ProviderInfo providerInfo) {
        boolean authenticated = providerService.authenticate(providerInfo.getUser(), providerInfo.getPass());
        if (authenticated && providerInfo.getUserType().equals("provider")) {
            return "redirect:/providerDashboard";
        } else {
            return "redirect:/providerLoginPage?error";
        }
    }

    @GetMapping("/providerDashboard")
    public String showDashboardPage() {
        return "providerDashboard";
    }

}
