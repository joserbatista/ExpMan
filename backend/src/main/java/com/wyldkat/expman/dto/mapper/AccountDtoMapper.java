package com.wyldkat.expman.dto.mapper;

import com.wyldkat.expman.dto.AccountDto;
import com.wyldkat.expman.dto.DtoMapper;
import com.wyldkat.expman.dto.IdAndValueDto;
import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.model.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountDtoMapper extends DtoMapper<AccountDto, Account> {

    private final UserDtoMapper userDtoMapper;

    @Autowired
    public AccountDtoMapper(UserDtoMapper userDtoMapper) {
        this.userDtoMapper = userDtoMapper;
    }

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
    public Account mapSimpleDtoToEntity(IdAndValueDto idAndValueDto) {
        Account account = new Account();
        account.setId(Long.valueOf(idAndValueDto.getId()));
        account.setName(idAndValueDto.getValue());
        return account;
    }

    @Override
    public IdAndValueDto mapEntityToSimpleDto(Account account) {
        return new IdAndValueDto(String.valueOf(account.getId()), account.getName());
    }

    public List<AccountDto.AccountTypeDto> mapTypesDtoToEntity(List<AccountType> accountTypes) {
        return accountTypes.stream().map(accountType -> AccountDto.AccountTypeDto.valueOf(accountType.name())).collect(Collectors.toList());
    }
}
