package com.bumajechky.controllers;

import com.bumajechky.domain.Card;
import com.bumajechky.domain.CardServiceResponse;
import com.bumajechky.domain.Pack;
import com.bumajechky.repositories.CardRepository;
import com.bumajechky.repositories.PackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pack/{packId}")
public class CardController {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    PackRepository packRepository;

    @PostMapping("/createcard")
    @ResponseBody
    public ResponseEntity<Object> createCard(@RequestBody Card card,
                                             @PathVariable("packId") Long packId) {

        System.out.println(card);
        card.setPack(packRepository.findById(packId).get());
        card = cardRepository.save(card);
        CardServiceResponse<Card> cardResponse = new CardServiceResponse<>("success", card);
        System.out.println("card response: " + cardResponse.toString());
        return new ResponseEntity<Object>(cardResponse, HttpStatus.OK);
    }

    @GetMapping("/cards")
    @ResponseBody
    public ResponseEntity<Object> getAllCards(@PathVariable("packId") Long packId) {

        List<Card> cards = cardRepository.findAllByPack(packRepository.findById(packId).get());
        CardServiceResponse<List<Card>> cardsResponse = new CardServiceResponse<>("success", cards);
        return new ResponseEntity<Object>(cardsResponse, HttpStatus.OK);
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
