package com.wyldkat.expman.config.repository;

import com.wyldkat.expman.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

