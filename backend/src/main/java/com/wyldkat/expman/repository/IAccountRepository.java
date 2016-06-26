package com.wyldkat.expman.repository;

import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAccountRepository extends CrudRepository<Account, Long> {

    List<Account> findByOwner(User owner);
}
