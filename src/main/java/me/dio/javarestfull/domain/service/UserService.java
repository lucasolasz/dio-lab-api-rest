package me.dio.javarestfull.domain.service;

import me.dio.javarestfull.domain.model.User;

public interface UserService {
    User findByid(Long id);

    User create(User userToCreate);
}
