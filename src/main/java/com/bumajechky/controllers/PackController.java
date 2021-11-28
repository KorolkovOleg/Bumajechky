package com.bumajechky.controllers;

import com.bumajechky.domain.Pack;
import com.bumajechky.domain.User;
import com.bumajechky.repositories.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class PackController {

    @Autowired
    PackRepository packRepository;

    @GetMapping("/packages")
    public String dashboardView(@AuthenticationPrincipal User user, ModelMap modelMap) {

        modelMap.put("pack", new Pack());
        modelMap.put("packages", packRepository.findAllByUsers(user));
        return "packages";
    }

    @GetMapping("/pack/{id}")
    public String pack(@PathVariable("id") int id) {
        return "pack";
    }

    @PostMapping("/createPack")
    public String createPack(@AuthenticationPrincipal User user, @ModelAttribute Pack pack) {
        pack.getUsers().add(user);
        pack = packRepository.saveAndFlush(pack);


        return "redirect:pack/" + pack.getId();
    }

    @GetMapping("/pack/{id}/edit")
    public String getEditPackTemplate() {
        return "packedit";
    }

}
