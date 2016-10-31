package com.wyldkat.expman.dto.mapper;

import com.wyldkat.expman.dto.UserDto;

public class UserDtoBuilder {
    private String username;
    private String email;
    private String fullName;
    private String createdDate;

    public UserDtoBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserDtoBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserDtoBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserDtoBuilder setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public UserDto build() {
        return new UserDto(username, email, fullName, createdDate);
    }
}
