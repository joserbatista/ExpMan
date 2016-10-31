package com.wyldkat.expman.dto.mapper;

import com.wyldkat.expman.dto.AccountDto;
import com.wyldkat.expman.dto.UserDto;

public class AccountDtoBuilder {
    private String id;
    private String name;
    private String notes;
    private boolean active;
    private AccountDto.AccountTypeDto type;
    private UserDto owner;

    public AccountDtoBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public AccountDtoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public AccountDtoBuilder setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public AccountDtoBuilder setActive(boolean active) {
        this.active = active;
        return this;
    }

    public AccountDtoBuilder setType(AccountDto.AccountTypeDto type) {
        this.type = type;
        return this;
    }

    public AccountDtoBuilder setOwner(UserDto owner) {
        this.owner = owner;
        return this;
    }

    public AccountDto build() {
        return new AccountDto(id, name, notes, active, type, owner);
    }
}
