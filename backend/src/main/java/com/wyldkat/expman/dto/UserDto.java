package com.wyldkat.expman.dto;

import java.util.Date;


public class UserDto extends BaseDto {
    private String username;
    private String email;
    private String fullName;
    private Date createdDate;

    public UserDto(String username, String email, String fullName, Date createdDate) {
        this.username = username;
        this.email = email;
        this.fullName = fullName;
        this.createdDate = createdDate;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
