package com.wyldkat.expman.dto;

import com.wyldkat.expman.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper extends DtoMapper<UserDto, User> {

    @Override
    public UserDto mapEntityToDto(User user) {
        return new UserDtoBuilder().
            setUsername(user.getUsername()).
            setEmail(user.getEmail()).
            setFullName(user.getFullName()).
            setCreatedDate(user.getCreatedDate()).build();
    }

    @Override
    public User mapDtoToEntity(UserDto userDto) {
        User user = new User();

        return user;
    }

    public UserDto mapSecurityEntityToDto(UserDetails user) {
        return new UserDtoBuilder().
            setUsername(user.getUsername()).build();
    }
}
