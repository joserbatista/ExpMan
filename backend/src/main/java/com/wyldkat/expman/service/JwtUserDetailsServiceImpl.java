package com.wyldkat.expman.service;

import com.wyldkat.expman.model.User;
import com.wyldkat.expman.modules.security.JwtUserFactory;
import com.wyldkat.expman.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class JwtUserDetailsServiceImpl implements UserDetailsService, IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(
                String.format("No user found with username '%s'.", username));
        }

        if (user.getAuthorities().isEmpty()) {
            throw new InsufficientAuthenticationException(
                String.format("No authorities found for username '%s", username));
        }

        return JwtUserFactory.create(user);
    }

    @Override
    public User loadDomainUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
