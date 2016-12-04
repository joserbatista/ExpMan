package com.wyldkat.expman.repository;

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
     * @return a list of transactions which owner is the user specified. If no transactions are found, this method
     * returns an empty list
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
     * Delete a transaction
     *
     * @param transaction the transaction to delete for user
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

    /**
     * Find all transactions owned by a certain user, filtering by a specific date range
     *
     * @param startDate the start date of the search
     * @param endDate   the end date of the search
     * @param user      the transactions owner
     * @return a list of transactions which obeys the specified parameters. If no transactions are found, this method
     * returns an empty list
     */
    List<Transaction> findByDateBetweenAndOwner(ZonedDateTime startDate, ZonedDateTime endDate, User user);

    /**
     * Find all transactions owned by a certain user, filtering by a specific date range, a list of category names
     * and a list of payee names
     *
     * @param startDate    the start date of the search
     * @param endDate      the end date of the search
     * @param user         the transactions owner
     * @param accountList  the list of account names to search for
     * @param categoryList the list of category names to search for
     * @param payeeList    the list of payee names to search for
     * @return a list of transactions which obeys the specified parameters. If no transactions are found, this method
     * returns an empty list
     */
    List<Transaction> findByDateBetweenAndOwnerAndAccountNameInAndCategoryNameInAndPayeeNameIn(ZonedDateTime startDate,
                                                                                               ZonedDateTime endDate,
                                                                                               User user,
                                                                                               List<String> accountList,
                                                                                               List<String> categoryList,
                                                                                               List<String> payeeList);

    List<Transaction> findByDateBetweenAndOwnerAndCategoryNameInAndPayeeNameIn(ZonedDateTime startDate,
                                                                               ZonedDateTime endDate,
                                                                               User user,
                                                                               List<String> categoryList,
                                                                               List<String> payeeList);

    List<Transaction> findByDateBetweenAndOwnerAndPayeeNameIn(ZonedDateTime startDate,
                                                              ZonedDateTime endDate,
                                                              User user,
                                                              List<String> payeeList);

    List<Transaction> findByDateBetweenAndOwnerAndAccountNameInAndCategoryNameIn(ZonedDateTime startDate,
                                                                                 ZonedDateTime endDate,
                                                                                 User user,
                                                                                 List<String> accountList,
                                                                                 List<String> categoryList);

    List<Transaction> findByDateBetweenAndOwnerAndCategoryNameIn(ZonedDateTime startDate,
                                                                 ZonedDateTime endDate,
                                                                 User user,
                                                                 List<String> categoryList);

    List<Transaction> findByDateBetweenAndOwnerAndAccountNameIn(ZonedDateTime startDate,
                                                                ZonedDateTime endDate,
                                                                User user,
                                                                List<String> accountList);
}