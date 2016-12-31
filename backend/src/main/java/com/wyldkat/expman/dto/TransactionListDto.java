package com.wyldkat.expman.dto;

import java.util.List;

/**
 * Created by Jos&eacute; Batista on 31/12/2016.
 */
public class TransactionListDto {
    private List<TransactionDto> transactions;
    private Integer transactionsCount;

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
        this.transactionsCount = transactions.size();
    }

    public Integer getTransactionsCount() {
        return transactionsCount;
    }
}
