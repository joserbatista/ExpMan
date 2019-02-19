package com.wyldkat.expman.dto;

import java.math.BigDecimal;

/**
 * Created by Jos&eacute; Batista on 01/11/2016.
 */
public class TransactionDto extends BaseDto {

    private String date;
    private IdAndValueDto account;
    private BigDecimal amount;
    private IdAndValueDto category;
    private IdAndValueDto payee;
    private String note;

    private TransactionDto(String id, String date, IdAndValueDto account, BigDecimal amount, IdAndValueDto category, IdAndValueDto payee,
        String note) {
        super(id);
        this.date = date;
        this.account = account;
        this.amount = amount;
        this.category = category;
        this.payee = payee;
        this.note = note;
    }

    public TransactionDto(String id) {
        super(id);
    }

    public TransactionDto() {
        super(null);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public IdAndValueDto getAccount() {
        return account;
    }

    public void setAccount(IdAndValueDto account) {
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public IdAndValueDto getCategory() {
        return category;
    }

    public void setCategory(IdAndValueDto category) {
        this.category = category;
    }

    public IdAndValueDto getPayee() {
        return payee;
    }

    public void setPayee(IdAndValueDto payee) {
        this.payee = payee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static class TransactionDtoBuilder {
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
}
