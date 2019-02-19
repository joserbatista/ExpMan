package com.wyldkat.expman.dto.mapper;

import com.wyldkat.expman.dto.AccountDto;
import com.wyldkat.expman.dto.DtoMapper;
import com.wyldkat.expman.dto.IdAndValueDto;
import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.model.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountDtoMapper implements DtoMapper<AccountDto, Account> {

    private final UserDtoMapper userDtoMapper;

    @Autowired
    public AccountDtoMapper(UserDtoMapper userDtoMapper) {
        this.userDtoMapper = userDtoMapper;
    }

    @Override
    public Optional<Account> mapDtoToEntity(AccountDto dto) {
        Account account = new Account();
        account.setName(dto.getName());
        account.setNotes(dto.getNotes());
        account.setActive(dto.isActive());
        account.setType(dto.getType() != null ? AccountType.valueOf(dto.getType().name()) : null);
        account.setId(dto.getId() != null ? Long.valueOf(dto.getId()) : null);

        return Optional.of(account);
    }

    @Override
    public Optional<AccountDto> mapEntityToDto(Account account) {

        AccountDto.AccountDtoBuilder builder = new AccountDto.AccountDtoBuilder();

        userDtoMapper.mapEntityToDto(account.getOwner()).ifPresent(builder::setOwner);

        AccountDto accountDto = builder.setName(account.getName())
                                       .setId(Long.toString(account.getId()))
                                       .setActive(account.isActive())
                                       .setNotes(account.getNotes())
                                       .setType(account.getType() != null ? AccountDto.AccountTypeDto.valueOf(account.getType().name()) : null)
                                       .setAmount(account.getAmount())
                                       .build();

        return Optional.of(accountDto);
    }

    @Override
    public Optional<Account> mapSimpleDtoToEntity(IdAndValueDto idAndValueDto) {
        Account account = new Account();
        account.setId(Long.valueOf(idAndValueDto.getId()));
        account.setName(idAndValueDto.getValue());
        return Optional.of(account);
    }

    @Override
    public Optional<IdAndValueDto> mapEntityToSimpleDto(Account account) {
        IdAndValueDto idAndValueDto = new IdAndValueDto(String.valueOf(account.getId()), account.getName());
        return Optional.of(idAndValueDto);
    }

    public List<AccountDto.AccountTypeDto> mapTypesDtoToEntity(List<AccountType> accountTypes) {
        return accountTypes.stream()
                           .map(Enum::name).map(AccountDto.AccountTypeDto::valueOf)
                           .collect(Collectors.toList());
    }
}
