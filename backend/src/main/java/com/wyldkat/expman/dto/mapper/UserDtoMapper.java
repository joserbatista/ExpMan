package com.wyldkat.expman.dto.mapper;

import com.wyldkat.expman.dto.DtoMapper;
import com.wyldkat.expman.dto.UserDto;
import com.wyldkat.expman.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
public class UserDtoMapper implements DtoMapper<UserDto, User> {

    @Override
    public Optional<User> mapDtoToEntity(UserDto userDto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<UserDto> mapEntityToDto(User user) {
        UserDto userDto = new UserDto.UserDtoBuilder()
            .setUsername(user.getUsername())
            .setEmail(user.getEmail())
            .setFullName(user.getFullName())
            .setCreatedDate(user.getCreatedDate().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
            .build();

        return Optional.ofNullable(userDto);
    }

    public UserDto mapSecurityEntityToDto(UserDetails user) {
        return new UserDto.UserDtoBuilder()
            .setUsername(user.getUsername()).build();
    }
}
