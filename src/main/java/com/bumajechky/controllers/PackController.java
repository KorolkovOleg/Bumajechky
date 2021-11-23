package com.bumajechky.controllers;

import com.bumajechky.domain.Pack;
import com.bumajechky.domain.User;
import com.bumajechky.repositories.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;

@Controller
public class PackController {

    @Autowired
    PackRepository packRepository;

    @GetMapping("/pack")
    public String pack() {
        return "package";
    }

    @PostMapping("/createPack")
    public String createPack(@AuthenticationPrincipal User user, @ModelAttribute Pack pack) {
        return "pack/" + pack.getName();
    }
}
