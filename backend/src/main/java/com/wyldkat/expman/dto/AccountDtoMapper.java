package com.wyldkat.expman.dto;

import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.model.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountDtoMapper extends DtoMapper<AccountDto, Account> {

    @Autowired
    private UserDtoMapper userDtoMapper;

    @Override
    public AccountDto mapEntityToDto(Account account) {

        return new AccountDtoBuilder().
            setName(account.getName()).
            setId(Long.toString(account.getId())).
            setActive(account.isActive()).
            setNotes(account.getNotes()).
            setOwner(userDtoMapper.mapEntityToDto(account.getOwner())).
            setType(account.getType() != null ? AccountDto.AccountTypeDto.valueOf(account.getType().name()) : null).
            build();
    }

    @Override
    public Account mapDtoToEntity(AccountDto dto) {
        Account account = new Account();
        account.setName(dto.getName());
        account.setNotes(dto.getNotes());
        account.setActive(dto.isActive());
        account.setType(dto.getType() != null ? AccountType.valueOf(dto.getType().name()) : null);
        account.setId(dto.getId() != null ? Long.valueOf(dto.getId()) : null);
        return account;
    }

    @Override
    public List<AccountDto> mapEntityListToDtoList(List<Account> accounts) {
        return accounts.stream().map(this::mapEntityToDto).map(this::stripOwner).collect(Collectors.toList());
    }

    private AccountDto stripOwner(AccountDto accountDto) {
        accountDto.setOwner(null);
        return accountDto;
    }

}
