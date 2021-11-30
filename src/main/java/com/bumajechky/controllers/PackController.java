package com.bumajechky.controllers;

import com.bumajechky.domain.Card;
import com.bumajechky.domain.Pack;
import com.bumajechky.domain.User;
import com.bumajechky.repositories.CardRepository;
import com.bumajechky.repositories.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PackController {

    @Autowired
    PackRepository packRepository;

    @Autowired
    CardRepository cardRepository;

    @GetMapping("/packages")
    public String dashboardView(@AuthenticationPrincipal User user, ModelMap modelMap) {

        modelMap.put("pack", new Pack());
        modelMap.put("packages", packRepository.findAllByUsers(user));
        return "packages";
    }

    @GetMapping("/pack/{id}")
    public String pack(@PathVariable("id") Long id, ModelMap modelMap) {
        Optional<Pack> pack = packRepository.findById(id);

        modelMap.put("card", new Card());
        modelMap.put("cards", cardRepository.findAllByPack(pack.get()));

        pack.ifPresent(value -> modelMap.put("pack", value));
        return "pack";
    }

    @PostMapping("/create")
    public String createPack(@AuthenticationPrincipal User user, @ModelAttribute Pack pack) {
        pack.getUsers().add(user);
        pack = packRepository.saveAndFlush(pack);
        return "redirect:pack/" + pack.getId();
    }

    @GetMapping("/pack/{id}/edit")
    public String getEditPackTemplate() {
        return "packedit";
    }

    @PatchMapping("pack/{id}/edit")
    public String editPackage(@PathVariable("id") Long id, @ModelAttribute Pack pack, @AuthenticationPrincipal User user) {
        System.out.println(pack);
        pack.getUsers().add(user);
        packRepository.saveAndFlush(pack);
        return "redirect:/pack/" + id;
    }

    @DeleteMapping("/pack/{id}")
    public String deletePackage(@PathVariable("id") Long id) {
        System.out.println(id);
        packRepository.deleteById(id);
        return "redirect:/packages";
    }

}
