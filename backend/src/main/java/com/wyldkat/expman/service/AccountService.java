package com.wyldkat.expman.service;

import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.model.AccountType;
import com.wyldkat.expman.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service("accountService")
public class AccountService extends OwnedEntityService<Account, IAccountRepository> implements IAccountService {

    @Autowired
    public AccountService(IUserService userDetailsService, IAccountRepository accountRepository) {
        super(accountRepository, userDetailsService);
    }


    @Override
    public List<AccountType> loadTypes() {
        return Arrays.asList(AccountType.values());
    }

}
