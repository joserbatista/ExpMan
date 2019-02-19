package com.wyldkat.expman.service;

import com.wyldkat.expman.model.TransactionFilter;
import com.wyldkat.expman.model.User;
import com.wyldkat.expman.repository.ITransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Jos&eacute; Batista on 27/11/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

    private static final List<String> STRING_LIST = Arrays.asList("STRING1", "STRING2");
    private static final String USERNAME = "OWNER";
    private TransactionService transactionService;
    private ITransactionRepository transactionRepository;
    private User user;
    private TransactionFilter.TransactionFilterBuilder transactionFilterBuilder;

    @Before
    public void setUp() {
        IUserService userDetailsService = mock(IUserService.class);
        ZonedDateTime startDate = ZonedDateTime.of(LocalDateTime.ofEpochSecond(0, 0, ZoneOffset.UTC), ZoneId.systemDefault());
        ZonedDateTime endDate = ZonedDateTime.now();
        transactionFilterBuilder = new TransactionFilter.TransactionFilterBuilder(startDate, endDate);
        transactionRepository = mock(ITransactionRepository.class);
        transactionService = new TransactionService(transactionRepository, userDetailsService);
        user = new User();
        user.setUsername(USERNAME);

        when(userDetailsService.loadDomainUserByUsername(USERNAME)).thenReturn(Optional.ofNullable(user));
    }

    @Test
    public void loadAllByDateBetweenAndOwner() {
        TransactionFilter transactionFilter = transactionFilterBuilder.withAccounts(null)
                                                                      .withCategories(null)
                                                                      .withPayees(null)
                                                                      .build();

        transactionService.loadAllByOwnerAndFilter(USERNAME, transactionFilter);

        verify(transactionRepository, times(1)).
                                                   findByDateBetweenAndOwner(transactionFilter.getStartDate(), transactionFilter.getEndDate(), user);
    }

    @Test
    public void loadAllByDateBetweenAndOwnerAndAccountNameIn() {
        TransactionFilter filter = transactionFilterBuilder.withAccounts(null)
                                                           .withCategories(null)
                                                           .withPayees(null)
                                                           .build();

        transactionService.loadAllByOwnerAndFilter(USERNAME, filter);

        verify(transactionRepository, times(1)).
                                                   findByDateBetweenAndOwner(filter.getStartDate(), filter.getEndDate(), user);
    }

    @Test
    public void loadAllByDateBetweenAndOwnerAndAccountNameInAndCategoryNameIn() {
        TransactionFilter filter = transactionFilterBuilder.withAccounts(STRING_LIST)
                                                           .withCategories(STRING_LIST)
                                                           .withPayees(null)
                                                           .build();

        transactionService.loadAllByOwnerAndFilter(USERNAME, filter);

        verify(transactionRepository, times(1)).
                                                   findByDateBetweenAndOwnerAndAccountNameInAndCategoryNameIn(
                                                       filter.getStartDate(), filter.getEndDate(), user,
                                                       filter.getAccounts(), filter.getCategories());
    }

    @Test
    public void loadAllByDateBetweenAndOwnerAndAccountNameInAndCategoryNameInAndPayeeNameIn() {
        TransactionFilter filter = transactionFilterBuilder.withAccounts(STRING_LIST)
                                                           .withCategories(STRING_LIST)
                                                           .withPayees(STRING_LIST)
                                                           .build();

        transactionService.loadAllByOwnerAndFilter(USERNAME, filter);

        verify(transactionRepository, times(1)).
                                                   findByDateBetweenAndOwnerAndAccountNameInAndCategoryNameInAndPayeeNameIn(
                                                       filter.getStartDate(), filter.getEndDate(), user,
                                                       filter.getAccounts(), filter.getCategories(), filter.getPayees());
    }

    @Test
    public void loadAllByDateBetweenAndOwnerAndCategoryNameIn() {
        TransactionFilter filter = transactionFilterBuilder.withAccounts(null)
                                                           .withCategories(STRING_LIST)
                                                           .withPayees(null)
                                                           .build();

        transactionService.loadAllByOwnerAndFilter(USERNAME, filter);

        verify(transactionRepository, times(1)).
                                                   findByDateBetweenAndOwnerAndCategoryNameIn(
                                                       filter.getStartDate(), filter.getEndDate(), user,
                                                       filter.getCategories());
    }

    @Test
    public void loadAllByDateBetweenAndOwnerAndCategoryNameInAndPayeeNameIn() {
        TransactionFilter filter = transactionFilterBuilder.withAccounts(null)
                                                           .withCategories(STRING_LIST)
                                                           .withPayees(STRING_LIST)
                                                           .build();

        transactionService.loadAllByOwnerAndFilter(USERNAME, filter);

        verify(transactionRepository, times(1)).
                                                   findByDateBetweenAndOwnerAndCategoryNameInAndPayeeNameIn(
                                                       filter.getStartDate(), filter.getEndDate(), user,
                                                       filter.getCategories(), filter.getPayees());
    }

    @Test
    public void loadAllByDateBetweenAndOwnerAndPayeeNameIn() {
        TransactionFilter filter = transactionFilterBuilder.withAccounts(null)
                                                           .withCategories(null)
                                                           .withPayees(STRING_LIST)
                                                           .build();

        transactionService.loadAllByOwnerAndFilter(USERNAME, filter);

        verify(transactionRepository, times(1)).
                                                   findByDateBetweenAndOwnerAndPayeeNameIn(
                                                       filter.getStartDate(), filter.getEndDate(), user,
                                                       filter.getPayees());
    }

}