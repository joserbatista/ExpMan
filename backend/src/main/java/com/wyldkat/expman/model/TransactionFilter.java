package com.wyldkat.expman.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jos&eacute; Batista on 01/11/2016.
 */
public class TransactionFilter {
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private List<String> accounts;
    private List<String> categories;
    private List<String> payees;

    public TransactionFilter() {
        // force date defaults
        this.setStartDate(null);
        this.setEndDate(null);
    }

    public TransactionFilter(ZonedDateTime startDate, ZonedDateTime endDate, List<String> accounts, List<String> categories, List<String> payees) {
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.accounts = accounts;
        this.categories = categories;
        this.payees = payees;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = (startDate == null) ?
                ZonedDateTime.of(LocalDateTime.ofEpochSecond(0, 0, ZoneOffset.UTC), ZoneId.systemDefault()) :
                startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = (endDate == null) ? ZonedDateTime.now() : endDate;
    }

    public List<String> getCategories() {
        if (categories == null)
            categories = new ArrayList<>();

        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getPayees() {
        if (payees == null)
            payees = new ArrayList<>();

        return payees;
    }

    public void setPayees(List<String> payees) {
        this.payees = payees;
    }


    public List<String> getAccounts() {
        if (accounts == null)
            accounts = new ArrayList<>();

        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }
}
