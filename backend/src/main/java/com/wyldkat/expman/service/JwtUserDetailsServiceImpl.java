package com.wyldkat.expman.service;

import com.wyldkat.expman.config.repository.UserRepository;
import com.wyldkat.expman.modules.security.JwtUserFactory;
import com.wyldkat.expman.modules.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }

        if (user.getAuthorities().isEmpty()) {
            throw new InsufficientAuthenticationException(
                    String.format("No authorities found for username '%s", username));
        }

        return JwtUserFactory.create(user);
    }
}