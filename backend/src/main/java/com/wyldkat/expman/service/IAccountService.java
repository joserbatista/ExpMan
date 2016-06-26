package com.wyldkat.expman.service;

import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.model.AccountType;

import java.util.List;

public interface IAccountService {
    List<Account> loadAccountsByOwner(String username);

    List<AccountType> loadAccountTypes();
}
