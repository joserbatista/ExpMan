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

    public TransactionDto(String id, String date, IdAndValueDto account, BigDecimal amount, IdAndValueDto category, IdAndValueDto payee, String note) {
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
}
