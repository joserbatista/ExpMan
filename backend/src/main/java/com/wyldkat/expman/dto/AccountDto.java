package com.wyldkat.expman.dto;

import java.math.BigDecimal;

public class AccountDto extends BaseDto {
    private String id;
    private String name;
    private String notes;
    private boolean active;
    private AccountTypeDto type;
    private UserDto owner;
    private BigDecimal amount;

    private AccountDto(String id, String name, String notes, boolean active, AccountTypeDto type, UserDto owner, BigDecimal amount) {
        super(id);
        this.name = name;
        this.notes = notes;
        this.active = active;
        this.type = type;
        this.owner = owner;
        this.amount = amount;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public enum AccountTypeDto {

        CASH,
        BANK,
        CREDIT_CARD,
        DEBIT_CARD,
        PAYPAL
    }


    public static class AccountDtoBuilder {
        private String id;
        private String name;
        private String notes;
        private boolean active;
        private AccountDto.AccountTypeDto type;
        private UserDto owner;
        private BigDecimal amount;

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

        public AccountDtoBuilder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public AccountDto build() {
            return new AccountDto(id, name, notes, active, type, owner, amount);
        }
    }

}
