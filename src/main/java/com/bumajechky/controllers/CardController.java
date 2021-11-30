package com.bumajechky.controllers;

import com.bumajechky.domain.Card;
import com.bumajechky.domain.Pack;
import com.bumajechky.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pack/{id}")
public class CardController {

    @Autowired
    CardRepository cardRepository;

    @PostMapping("/createcard")
    public String createCard(   @ModelAttribute("card") Card card,
                                @ModelAttribute("pack") Pack pack) {
        card.setPack(pack);
        cardRepository.save(card);
        return "redirect:/pack/" + pack.getId() + "/";
    }

    @DeleteMapping("/deletecard/{cardId}")
    public String deleteCard(   @ModelAttribute("pack") Pack pack,
                                @PathVariable("cardId") Long cardId) {
        cardRepository.deleteById(cardId);
        return "redirect:/pack/" + pack.getId() + "/";
    }

    @GetMapping("/{cardId}")
    public String getCard(@PathVariable("cardId") Long cardId, ModelMap modelMap) {
        Card card = cardRepository.findById(cardId).get();
        return "card";
    }
}
