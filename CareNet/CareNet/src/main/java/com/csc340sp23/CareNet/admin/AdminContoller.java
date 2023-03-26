package com.csc340sp23.CareNet.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminContoller implements ErrorController{
    

    @Autowired
    private AdminService adminService;

    @GetMapping("/adminLoginPage")
    public String adminLogin(Model model) {
        model.addAttribute("adminInfo", new AdminInfo());
        return "adminLoginPage";
    }

    @PostMapping("/adminLoginPage")
    public String processLoginForm(@ModelAttribute("adminInfo") AdminInfo adminInfo) {
        boolean authenticated = adminService.authenticate(adminInfo.getUser(), adminInfo.getPass());
        if (authenticated && adminInfo.getUserType().equals("admin")) {
            return "redirect:/adminDashboard";
        } else {
            return "redirect:/adminLoginPage?error";
        }
    }

    @GetMapping("/adminDashboard")
    public String showDashboardPage() {
        return "adminDashboard";
    }

}
