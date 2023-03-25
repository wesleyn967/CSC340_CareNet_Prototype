package com.csc340sp23.CareNet.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminContoller {

    @Autowired
    private AdminService adminService;

    @GetMapping("/adminLogin")
    public String adminLogin(Model model) {
        model.addAttribute("adminInfo", new AdminInfo());
        return "adminLogin";
    }

    @PostMapping("/adminLogin")
    public String processLoginForm(@ModelAttribute("adminInfo") AdminInfo adminInfo) {
        boolean authenticated = adminService.authenticate(adminInfo.getUser(), adminInfo.getPass());
        if (authenticated) {
            return "redirect:/dashboard";
        } else {
            return "redirect:/adminLogin?error";
        }
    }

    @GetMapping("/adminLogin/dashboard")
    public String showDashboardPage() {
        return "/adminLogin/dashboard";
    }

}
