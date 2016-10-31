package com.wyldkat.expman.service;

import com.wyldkat.expman.controller.exception.InternalServerErrorException;
import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.model.AccountType;
import com.wyldkat.expman.model.User;
import com.wyldkat.expman.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service("accountService")
public class AccountService implements IAccountService {

    private final IAccountRepository accountRepository;

    private final IUserService userDetailsService;

    @Autowired
    public AccountService(IUserService userDetailsService, IAccountRepository accountRepository) {
        this.userDetailsService = userDetailsService;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> loadAllByOwner(String username) {
        User user = getUser(username);

        return accountRepository.findByOwner(user);
    }

    @Override
    public List<AccountType> loadTypes() {

        return Arrays.asList(AccountType.values());
    }

    @Override
    public boolean saveForUser(Account account, String username) {
        User user = getUser(username);

        account.setOwner(user);

        Optional<Account> accountSaved = Optional.ofNullable(accountRepository.save(account));
        return accountSaved.isPresent();
    }

    @Override
    public Optional<Account> loadByOwnerAndId(String username, Long id) {
        User user = getUser(username);

        return Optional.ofNullable(accountRepository.findOneByOwnerAndId(user, id));
    }

    @Override
    public Account createForUser(Account account, String username) {
        User user = getUser(username);

        account.setOwner(user);

        Optional<Account> accountSaved = Optional.ofNullable(accountRepository.save(account));

        if (!accountSaved.isPresent()) {
            throw new InternalServerErrorException("Account could not be saved!");
        }

        return accountSaved.get();
    }

    private User getUser(String username) {
        Optional<User> user = userDetailsService.loadDomainUserByUsername(username);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
        return user.get();
    }
}
