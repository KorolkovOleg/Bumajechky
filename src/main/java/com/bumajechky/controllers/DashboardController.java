package com.bumajechky.controllers;

import com.bumajechky.domain.Pack;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {

    @GetMapping(value = "/")
    public String rootView() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboardView(ModelMap modelMap) {

        modelMap.put("pack", new Pack());
        return "dashboard";
    }
}
