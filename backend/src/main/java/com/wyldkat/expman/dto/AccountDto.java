package com.wyldkat.expman.dto;

public class AccountDto extends BaseDto {
    private String id;
    private String name;
    private String notes;
    private boolean active;
    private AccountTypeDto type;
    private UserDto owner;

    public AccountDto() {
    }

    public AccountDto(String id, String name, String notes, boolean active, AccountTypeDto type, UserDto owner) {
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.active = active;
        this.type = type;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public AccountTypeDto getType() {
        return type;
    }

    public void setType(AccountTypeDto type) {
        this.type = type;
    }

    public UserDto getOwner() {
        return owner;
    }

    public void setOwner(UserDto owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public enum AccountTypeDto {

        CASH, BANK, CREDIT_CARD, DEBIT_CARD, PAYPAL
    }
}
