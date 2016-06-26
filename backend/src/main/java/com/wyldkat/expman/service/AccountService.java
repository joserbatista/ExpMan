package com.wyldkat.expman.service;

import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.model.AccountType;
import com.wyldkat.expman.model.User;
import com.wyldkat.expman.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("accountService")
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private IUserService userDetailsService;

    @Override
    public List<Account> loadAccountsByOwner(String username) {
        User user = userDetailsService.loadDomainUserByUsername(username);
        return accountRepository.findByOwner(user);
    }

    @Override
    public List<AccountType> loadAccountTypes() {

        return Arrays.asList(AccountType.values());
    }
}
