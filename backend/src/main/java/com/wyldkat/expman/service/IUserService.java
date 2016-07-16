package com.wyldkat.expman.service;

import com.wyldkat.expman.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface IUserService {
    Optional<User> loadDomainUserByUsername(String username) throws UsernameNotFoundException;
}
