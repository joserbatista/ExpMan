package com.wyldkat.expman.service;

import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.model.AccountType;

import java.util.List;

/**
 * Created by Jos&eacute; Batista on 01/11/2016.
 */
public interface IAccountService extends IOwnedEntityService<Account> {
    List<AccountType> loadTypes();
}
