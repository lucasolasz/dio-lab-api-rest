package me.dio.javarestfull.domain.service;

import me.dio.javarestfull.domain.model.Card;
import me.dio.javarestfull.domain.model.User;

public interface CardService {
    Card findByid(Long id);

    Card create(Card cardToCreate);
}
