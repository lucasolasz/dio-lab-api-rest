package me.dio.javarestfull.domain.service;

import me.dio.javarestfull.domain.model.Card;
import me.dio.javarestfull.domain.model.User;
import me.dio.javarestfull.domain.repository.CardRepository;
import me.dio.javarestfull.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }
    @Override
    public Card findByid(Long id) {
        return cardRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Card create(Card cardToCreate) {
        if(cardRepository.existsByNumber(cardToCreate.getNumber())){
            throw new IllegalArgumentException("This Card number already exists");
        }
        return cardRepository.save(cardToCreate);
    }
}
