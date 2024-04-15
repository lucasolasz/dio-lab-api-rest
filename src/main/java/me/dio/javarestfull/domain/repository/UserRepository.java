package me.dio.javarestfull.domain.repository;

import me.dio.javarestfull.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
