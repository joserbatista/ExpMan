package com.wyldkat.expman.controller;

import com.wyldkat.expman.dto.AccountDto;
import com.wyldkat.expman.dto.mapper.AccountDtoMapper;
import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.modules.security.JwtTokenUtil;
import com.wyldkat.expman.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user/account")
public class AccountController extends BaseOwnedEntityController<Account, AccountDto, AccountDtoMapper, IAccountService> {

    private final IAccountService accountService;
    private final AccountDtoMapper accountMapper;

    @Autowired
    public AccountController(JwtTokenUtil jwtTokenUtil, IAccountService accountService, AccountDtoMapper accountMapper) {
        super(accountMapper, accountService, jwtTokenUtil);
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping(value = "types")
    public ResponseEntity<List<AccountDto.AccountTypeDto>> getAccountTypes() {
        return ResponseEntity.ok(accountMapper.mapTypesDtoToEntity(accountService.loadTypes()));
    }
}
