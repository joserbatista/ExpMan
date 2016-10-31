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

import java.util.Optional;

@Service("userDetailsService")
public class JwtUserDetailsServiceImpl implements UserDetailsService, IUserService {

    private final IUserRepository userRepository;

    @Autowired
    public JwtUserDetailsServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = loadDomainUserByUsername(username);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }

        User userFromOptional = user.get();

        if (userFromOptional.getAuthorities().isEmpty()) {
            throw new InsufficientAuthenticationException(String.format("No authorities found for username '%s", username));
        }

        return JwtUserFactory.create(userFromOptional);
    }

    @Override
    public Optional<User> loadDomainUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }
}
