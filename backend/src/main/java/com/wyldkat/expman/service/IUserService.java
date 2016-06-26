package com.wyldkat.expman.service;

import com.wyldkat.expman.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserService {
    User loadDomainUserByUsername(String username) throws UsernameNotFoundException;
}
