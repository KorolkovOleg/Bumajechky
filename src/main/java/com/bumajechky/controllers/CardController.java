package com.bumajechky.controllers;

import com.bumajechky.domain.Card;
import com.bumajechky.domain.Pack;
import com.bumajechky.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pack/{id}")
public class CardController {

    @Autowired
    CardRepository cardRepository;

    @PostMapping("/createcard")
    public String createCard(@ModelAttribute("card") Card card,
                             @ModelAttribute("pack") Pack pack) {
        card.setPack(pack);
        cardRepository.save(card);
        return "redirect:/pack/" + pack.getId() + "/";
    }


}
