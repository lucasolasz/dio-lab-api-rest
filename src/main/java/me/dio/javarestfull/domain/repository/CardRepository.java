package me.dio.javarestfull.domain.repository;

import me.dio.javarestfull.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
    boolean existsByNumber(String accountNumber);
}
