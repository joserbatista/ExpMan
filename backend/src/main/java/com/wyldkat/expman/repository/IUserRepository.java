package com.wyldkat.expman.repository;

import com.wyldkat.expman.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}

