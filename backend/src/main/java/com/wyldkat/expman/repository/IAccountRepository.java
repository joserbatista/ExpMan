package com.wyldkat.expman.repository;

import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Specifies methods used to query and modify account related information stored in database
 *
 * @author José Batista
 */
public interface IAccountRepository extends CrudRepository<Account, Long>, IOwnedEntityRepository<Account> {

    /**
     * Find all accounts owned by a certain user
     *
     * @param owner the account owner
     * @return a list of accounts which owner is the user specified. If no accounts are found, this method returns an empty list
     */
    @Override
    List<Account> findByOwner(User owner);

    /**
     * Save an account with the specified parameters
     *
     * @param account the account to save for user
     * @return the saved account
     */
    @SuppressWarnings("unchecked")
    @Override
    Account save(Account account);

    /**
     * Delete an account with the specified parameters
     */
    @SuppressWarnings("unchecked")
    @Override
    void delete(Account account);

    /**
     * Find the account with the specified id for the specified owner
     *
     * @param user the account owner
     * @param id   the id of the account to retrieve
     * @return the account found on the database. If no account is found, this method returns null
     */
    @Override
    Account findOneByOwnerAndId(User user, Long id);

}
