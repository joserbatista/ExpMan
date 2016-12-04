package com.wyldkat.expman.service;


import com.wyldkat.expman.model.Transaction;
import com.wyldkat.expman.model.TransactionFilter;
import com.wyldkat.expman.model.User;
import com.wyldkat.expman.repository.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("transactionService")
public class TransactionService extends OwnedEntityService<Transaction, ITransactionRepository> implements ITransactionService {

    private final ITransactionRepository repository;

    @Autowired
    public TransactionService(ITransactionRepository repository, IUserService userDetailsService) {
        super(repository, userDetailsService);
        this.repository = repository;
    }

    @Override
    public List<Transaction> loadAllByOwnerAndFilter(String username, TransactionFilter transactionFilter) {
        User user = getUser(username);

        List<String> payeeList = transactionFilter.getPayees();
        List<String> categoryList = transactionFilter.getCategories();
        List<String> accountsList = transactionFilter.getAccounts();

        // if account, category and payee are not set, we want all the records between the set dates
        if (categoryList.isEmpty() && payeeList.isEmpty() && accountsList.isEmpty()) {
            return repository.findByDateBetweenAndOwner(
                    transactionFilter.getStartDate(),
                    transactionFilter.getEndDate(),
                    user);
        }

        // if account, category and payee are all set, we want all the records that match those values, between the set dates
        if (!accountsList.isEmpty() && !categoryList.isEmpty() && !payeeList.isEmpty()) {
            return repository.findByDateBetweenAndOwnerAndAccountNameInAndCategoryNameInAndPayeeNameIn(
                    transactionFilter.getStartDate(),
                    transactionFilter.getEndDate(),
                    user,
                    accountsList,
                    categoryList,
                    payeeList);
        }

        // if category is set but the payee and account are not, we want all the records that match only those categories, between the set dates
        if (!categoryList.isEmpty() && payeeList.isEmpty() && accountsList.isEmpty()) {
            return repository.findByDateBetweenAndOwnerAndCategoryNameIn(
                    transactionFilter.getStartDate(),
                    transactionFilter.getEndDate(),
                    user,
                    categoryList);
        }

        // if account is set but the category and payee are not, we want all the records that match only that account, between the set dates
        if (categoryList.isEmpty() && payeeList.isEmpty() && !accountsList.isEmpty()) {
            return repository.findByDateBetweenAndOwnerAndAccountNameIn(transactionFilter.getStartDate(), transactionFilter.getEndDate(), user, accountsList);
        }

        // if category and account are not set but the payee is, we want all the records that match only those payees, between the set dates
        if (categoryList.isEmpty() && accountsList.isEmpty() && !payeeList.isEmpty()) {
            return repository.findByDateBetweenAndOwnerAndPayeeNameIn(
                    transactionFilter.getStartDate(),
                    transactionFilter.getEndDate(),
                    user,
                    payeeList);
        }

        // if category and account are set but the payee is not, we want all the records that match only those categories and accounts, between the set dates
        if (!categoryList.isEmpty() && !accountsList.isEmpty() && payeeList.isEmpty()) {
            return repository.findByDateBetweenAndOwnerAndAccountNameInAndCategoryNameIn(
                    transactionFilter.getStartDate(),
                    transactionFilter.getEndDate(),
                    user,
                    accountsList,
                    categoryList);
        }

        // if category and payee are set but the account is not, we want all the records that match only those categories and payees, between the set dates
        if (!categoryList.isEmpty() && !payeeList.isEmpty() && accountsList.isEmpty()) {
            return repository.findByDateBetweenAndOwnerAndCategoryNameInAndPayeeNameIn(
                    transactionFilter.getStartDate(),
                    transactionFilter.getEndDate(),
                    user,
                    categoryList,
                    payeeList);
        }


        return Collections.emptyList();
    }
}
