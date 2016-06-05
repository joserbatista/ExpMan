package com.wyldkat.expman.config.repository;

import com.wyldkat.expman.modules.security.model.Authority;
import com.wyldkat.expman.modules.security.model.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.Date;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {


    @Override
    public User findByUsername(String username) {
        User user = new User();
        user.setId((long) 1);
        user.setUsername("wyldkat");
        user.setPassword("$2a$08$.5Ev0tOtuNCfV0Oh1HIGDup/weNeVa2r4WNbfVK2ZUB1mkubP7R42");
        user.setEmail("josebatista15@gmail.com");
        user.setEnabled(true);
        user.setFirstname("Jose");
        user.setLastname("Batista");
        user.setLastPasswordResetDate(new Date(1465160000));

        Authority authority = new Authority();
        authority.setId((long) 1);
        authority.setName(Authority.AuthorityName.ROLE_USER);

        user.setAuthorities(Collections.singletonList(authority));

        return user;
    }
}
