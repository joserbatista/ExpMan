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
    private IUserService userDetailsService;
    private ICategoryService categoryService;
    private IPayeeService payeeService;

    @Autowired
    public TransactionService(ITransactionRepository repository, IUserService userDetailsService, ICategoryService categoryService, IPayeeService payeeService) {
        super(repository, userDetailsService);
        this.repository = repository;
        this.userDetailsService = userDetailsService;
        this.categoryService = categoryService;
        this.payeeService = payeeService;
    }

    @Override
    public List<Transaction> loadAllByOwnerAndFilter(String username, TransactionFilter transactionFilter) {
        User user = getUser(username);

        List<String> payeeList = transactionFilter.getPayees();
        List<String> categoryList = transactionFilter.getCategories();

        // if category and payee are not set, we want all the records between the set dates
        if (categoryList.isEmpty() && payeeList.isEmpty()) {
            return repository.findByDateBetweenAndOwner(
                    transactionFilter.getStartDate(), transactionFilter.getEndDate(), user);
        }

        // if category and payee are both set, we want all the records that match those values, between the set dates
        if (!categoryList.isEmpty() && !payeeList.isEmpty()) {
            return repository.findByDateBetweenAndCategoryNameInAndPayeeNameInAndOwner(
                    transactionFilter.getStartDate(), transactionFilter.getEndDate(),
                    categoryList, payeeList, user);
        }

        // if category is set but the payee is not, we want all the records that match only those categories, between the set dates
        if (!categoryList.isEmpty() && payeeList.isEmpty()) {
            return repository.findByDateBetweenAndCategoryNameInAndOwner(
                    transactionFilter.getStartDate(), transactionFilter.getEndDate(),
                    categoryList, user);
        }

        // if category is not set but the payee is, we want all the records that match only those payees, between the set dates
        if (categoryList.isEmpty() && !payeeList.isEmpty()) {
            return repository.findByDateBetweenAndPayeeNameInAndOwner(
                    transactionFilter.getStartDate(), transactionFilter.getEndDate(),
                    payeeList, user);
        }

        return Collections.emptyList();
    }
}
