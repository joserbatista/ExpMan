package com.wyldkat.expman.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class TransactionBuilder {
    private Long id;
    private ZonedDateTime date;
    private Account account;
    private BigDecimal amount;
    private Category category;
    private Payee payee;
    private String note;

    public TransactionBuilder(Long id) {
        this.id = id;
    }

    public TransactionBuilder withDate(ZonedDateTime date) {
        this.date = date;
        return this;
    }

    public TransactionBuilder withAccount(Account account) {
        this.account = account;
        return this;
    }

    public TransactionBuilder withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public TransactionBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public TransactionBuilder withPayee(Payee payee) {
        this.payee = payee;
        return this;
    }

    public TransactionBuilder withNote(String note) {
        this.note = note;
        return this;
    }

    public Transaction build() {
        Transaction transaction = new Transaction();
        transaction.setId(id);
        transaction.setAccount(account);
        transaction.setAmount(amount);
        transaction.setCategory(category);
        transaction.setDate(date);
        transaction.setNote(note);
        transaction.setPayee(payee);
        return transaction;
    }

}