package com.wyldkat.expman.service;


import com.wyldkat.expman.model.*;
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

        List<Payee> payeeList = transactionFilter.getPayees();
        List<Category> categoryList = transactionFilter.getCategories();

        // if category and payee are not set, we want all the records between the set dates
        if (categoryList.isEmpty() && payeeList.isEmpty()) {
            return repository.findByDateBetweenAndOwner(
                    transactionFilter.getStartDate(), transactionFilter.getEndDate(), user);
        }

        mapExistingCategories(categoryList, user);
        mapExistingPayees(payeeList, user);

        // if category and payee are both set, we want all the records that match those values, between the set dates
        if (!categoryList.isEmpty() && !payeeList.isEmpty()) {
            return repository.findByDateBetweenAndCategoryInAndPayeeInAndOwner(
                    transactionFilter.getStartDate(), transactionFilter.getEndDate(),
                    categoryList, payeeList, user);
        }

        // if category is set but the payee is not, we want all the records that match only that category, between the set dates
        if (!categoryList.isEmpty() && payeeList.isEmpty()) {
            return repository.findByDateBetweenAndCategoryInAndOwner(
                    transactionFilter.getStartDate(), transactionFilter.getEndDate(),
                    categoryList, user);
        }

        // if category is not set but the payee is, we want all the records that match only that payee, between the set dates
        if (categoryList.isEmpty() && !payeeList.isEmpty()) {
            return repository.findByDateBetweenAndPayeeInAndOwner(
                    transactionFilter.getStartDate(), transactionFilter.getEndDate(),
                    payeeList, user);
        }

        return Collections.emptyList();
    }

    /**
     * Method to fetch the existing database payee entries base on the name
     *
     * @param payeeList the source list
     * @param user      the owner of the payee
     */
    private void mapExistingPayees(List<Payee> payeeList, User user) {
        for (Payee payee : payeeList) {
            String payeeName = payee.getName();
            payeeList.remove(payee);
            payeeList.add(payeeService.loadByOwnerAndName(user, payeeName));
        }
    }

    /**
     * Method to fetch the existing database categories entries base on the name
     *
     * @param categoryList the source list
     * @param user         the owner of the category
     */
    private void mapExistingCategories(List<Category> categoryList, User user) {
        for (Category category : categoryList) {
            String categoryName = category.getName();
            categoryList.remove(category);
            categoryList.add(categoryService.loadByOwnerAndName(user, categoryName));
        }
    }
}
