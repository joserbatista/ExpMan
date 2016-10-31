package com.wyldkat.expman.service;

import com.wyldkat.expman.model.Transaction;
import com.wyldkat.expman.model.TransactionFilter;

import java.util.List;

/**
 * Created by Jos&eacute; Batista on 01/11/2016.
 */
public interface ITransactionService extends IOwnedEntityService<Transaction> {
    List<Transaction> loadAllByOwnerAndFilter(String username, TransactionFilter transactionFilter);
}
