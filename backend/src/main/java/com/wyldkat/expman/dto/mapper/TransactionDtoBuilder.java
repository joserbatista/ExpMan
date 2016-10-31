package com.wyldkat.expman.dto.mapper;

import com.wyldkat.expman.dto.IdAndValueDto;
import com.wyldkat.expman.dto.TransactionDto;

import java.math.BigDecimal;

public class TransactionDtoBuilder {
    private String id;
    private String date;
    private IdAndValueDto account;
    private BigDecimal amount;
    private IdAndValueDto category;
    private IdAndValueDto payee;
    private String note;

    public TransactionDtoBuilder(String id) {
        this.id = id;
    }

    public TransactionDtoBuilder withDate(String date) {
        this.date = date;
        return this;
    }

    public TransactionDtoBuilder withAccount(IdAndValueDto account) {
        this.account = account;
        return this;
    }

    public TransactionDtoBuilder withAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public TransactionDtoBuilder withCategory(IdAndValueDto category) {
        this.category = category;
        return this;
    }

    public TransactionDtoBuilder withPayee(IdAndValueDto payee) {
        this.payee = payee;
        return this;
    }

    public TransactionDtoBuilder withNote(String note) {
        this.note = note;
        return this;
    }

    public TransactionDto build() {
        TransactionDto transactionDto = new TransactionDto(id);
        transactionDto.setAccount(account);
        transactionDto.setAmount(amount);
        transactionDto.setCategory(category);
        transactionDto.setDate(date);
        transactionDto.setNote(note);
        transactionDto.setPayee(payee);
        return transactionDto;
    }

}