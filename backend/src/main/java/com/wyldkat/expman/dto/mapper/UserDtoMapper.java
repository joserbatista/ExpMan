package com.wyldkat.expman.dto.mapper;

import com.wyldkat.expman.dto.DtoMapper;
import com.wyldkat.expman.dto.UserDto;
import com.wyldkat.expman.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class UserDtoMapper implements DtoMapper<UserDto, User> {

    @Override
    public UserDto mapEntityToDto(User user) {
        return new UserDtoBuilder().
                setUsername(user.getUsername()).
                setEmail(user.getEmail()).
                setFullName(user.getFullName()).
                setCreatedDate(user.getCreatedDate().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)).build();
    }

    @Override
    public User mapDtoToEntity(UserDto userDto) {
        throw new UnsupportedOperationException();
    }

    public UserDto mapSecurityEntityToDto(UserDetails user) {
        return new UserDtoBuilder().
                setUsername(user.getUsername()).build();
    }
}
