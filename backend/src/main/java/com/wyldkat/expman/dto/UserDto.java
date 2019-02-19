package com.wyldkat.expman.dto;

public class UserDto extends BaseDto {
    private String username;
    private String email;
    private String fullName;
    private String createdDate;

    public UserDto() {
    }

    public UserDto(String username, String email, String fullName, String createdDate) {
        super(null);
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

    public String getCreatedDate() {
        return createdDate;
    }

    public static class UserDtoBuilder {
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

}
