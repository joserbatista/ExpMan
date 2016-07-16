package com.wyldkat.expman.dto;

import java.util.Date;

public class UserDtoBuilder {
    private String username;
    private String email;
    private String fullName;
    private Date createdDate;

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

    public UserDtoBuilder setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public UserDto build() {
        return new UserDto(username, email, fullName, createdDate);
    }
}
