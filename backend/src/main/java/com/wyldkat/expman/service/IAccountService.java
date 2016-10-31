package com.wyldkat.expman.service;

import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.model.AccountType;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    List<Account> loadAllByOwner(String username);

    List<AccountType> loadTypes();

    boolean saveForUser(Account account, String username);

    Optional<Account> loadByOwnerAndId(String username, Long name);

    Account createForUser(Account account, String username);

    void removeForUser(Long accountId, String username);
}
