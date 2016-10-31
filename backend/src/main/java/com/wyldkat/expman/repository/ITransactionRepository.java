package com.wyldkat.expman.repository;

import com.wyldkat.expman.model.Category;
import com.wyldkat.expman.model.Payee;
import com.wyldkat.expman.model.Transaction;
import com.wyldkat.expman.model.User;
import org.springframework.data.repository.CrudRepository;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Jos&eacute; Batista on 01/11/2016.
 */
public interface ITransactionRepository extends CrudRepository<Transaction, Long>, IOwnedEntityRepository<Transaction> {

    /**
     * Find all transactions owned by a certain user
     *
     * @param owner the transaction owner
     * @return a list of transactions which owner is the user specified. If no transactions are found, this method returns an empty list
     */
    @Override
    List<Transaction> findByOwner(User owner);

    /**
     * Save an transaction with the specified parameters
     *
     * @param transaction the transaction to save for user
     * @return the saved transaction
     */
    @SuppressWarnings("unchecked")
    @Override
    Transaction save(Transaction transaction);

    /**
     * Delete an transaction with the specified parameters
     */
    @SuppressWarnings("unchecked")
    @Override
    void delete(Transaction transaction);

    /**
     * Find the transaction with the specified id for the specified owner
     *
     * @param user the transaction owner
     * @param id   the id of the transaction to retrieve
     * @return the transaction found on the database. If no transaction is found, this method returns null
     */
    @Override
    Transaction findOneByOwnerAndId(User user, Long id);

    List<Transaction> findByDateBetweenAndCategoryInAndPayeeInAndOwner(ZonedDateTime startDate, ZonedDateTime endDate, List<Category> categories, List<Payee> payees, User user);

    List<Transaction> findByDateBetweenAndOwner(ZonedDateTime startDate, ZonedDateTime endDate, User user);

    List<Transaction> findByDateBetweenAndCategoryInAndOwner(ZonedDateTime startDate, ZonedDateTime endDate, List<Category> categories, User user);

    List<Transaction> findByDateBetweenAndPayeeInAndOwner(ZonedDateTime startDate, ZonedDateTime endDate, List<Payee> payees, User user);
}