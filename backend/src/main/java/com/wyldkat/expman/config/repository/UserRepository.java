package com.wyldkat.expman.config.repository;

import com.wyldkat.expman.modules.security.model.User;

public interface UserRepository {
    User findByUsername(String username);
}

