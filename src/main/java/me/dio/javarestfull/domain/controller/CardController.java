package me.dio.javarestfull.domain.controller;


import me.dio.javarestfull.domain.model.Card;
import me.dio.javarestfull.domain.service.CardService;
import me.dio.javarestfull.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService){
        this.cardService = cardService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> findByid(@PathVariable Long id){
        var card = cardService.findByid(id);
        return ResponseEntity.ok(card);
    }

    @PostMapping
    public ResponseEntity<Card> create (@RequestBody Card cardToCreate){
        var cardCreated = cardService.create(cardToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cardCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(cardCreated);
    }
}
