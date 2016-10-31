package com.wyldkat.expman.controller;

import com.google.common.base.Strings;
import com.wyldkat.expman.controller.exception.InternalServerErrorException;
import com.wyldkat.expman.controller.exception.InvalidParameterException;
import com.wyldkat.expman.dto.AccountDto;
import com.wyldkat.expman.dto.AccountDtoMapper;
import com.wyldkat.expman.dto.IdOnlyDto;
import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.model.AccountType;
import com.wyldkat.expman.modules.security.JwtTokenUtil;
import com.wyldkat.expman.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user/account")
public class AccountController {

    private final JwtTokenUtil jwtTokenUtil;

    private final IAccountService accountService;

    private final AccountDtoMapper accountMapper;

    @Autowired
    public AccountController(AccountDtoMapper accountMapper, IAccountService accountService, JwtTokenUtil jwtTokenUtil) {
        this.accountMapper = accountMapper;
        this.accountService = accountService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AccountDto>> getCurrentUserAccounts(HttpServletRequest request) {
        String username = jwtTokenUtil.getUsernameFromRequest(request);

        return ResponseEntity.ok(accountMapper.mapEntityListToDtoList(accountService.loadAllByOwner(username)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<AccountDto> getCurrentUserAccountById(HttpServletRequest request, @PathVariable Long id) {
        Optional<Account> account = accountService.loadByOwnerAndId(jwtTokenUtil.getUsernameFromRequest(request), id);

        if (account.isPresent()) {
            return ResponseEntity.ok(accountMapper.mapEntityToDto(account.get()));
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @RequestMapping(value = "types", method = RequestMethod.GET)
    public ResponseEntity<List<AccountType>> getAccountTypes() {

        return ResponseEntity.ok(accountService.loadTypes());
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ResponseEntity<IdOnlyDto> updateAccountForCurrentUser(HttpServletRequest request, @RequestBody AccountDto account) {
        getCurrentUserAccountById(request, Long.valueOf(account.getId()));

        boolean saved =
                accountService.saveForUser(accountMapper.mapDtoToEntity(account), jwtTokenUtil.getUsernameFromRequest(request));

        if (!saved) {
            throw new InternalServerErrorException();
        } else {
            return ResponseEntity.ok(new IdOnlyDto(account.getId()));
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<IdOnlyDto> createAccountForCurrentUser(HttpServletRequest request,
                                                                 @RequestBody AccountDto account) {

        if (!Strings.isNullOrEmpty(account.getId())) {
            throw new InvalidParameterException("You should not set the account id");
        }

        Account saved = accountService
                .createForUser(accountMapper.mapDtoToEntity(account), jwtTokenUtil.getUsernameFromRequest(request));

        return ResponseEntity.ok(new IdOnlyDto(Long.toString(saved.getId())));
    }
}
