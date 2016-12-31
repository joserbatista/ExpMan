package com.wyldkat.expman.model.builder;

import com.google.common.base.Strings;
import com.wyldkat.expman.model.TransactionFilter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TransactionFilterBuilder {
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private List<String> accounts;
    private List<String> categories;
    private List<String> payees;

    public TransactionFilterBuilder withStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public TransactionFilterBuilder withEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public TransactionFilterBuilder withStartDate(String startDate) {
        if (!Strings.isNullOrEmpty(startDate)) {
            this.startDate = ZonedDateTime.parse(startDate, DateTimeFormatter.ISO_ZONED_DATE_TIME);
        }

        return this;
    }

    public TransactionFilterBuilder withEndDate(String endDate) {
        if (!Strings.isNullOrEmpty(endDate)) {
            this.endDate = ZonedDateTime.parse(endDate, DateTimeFormatter.ISO_ZONED_DATE_TIME);
        }

        return this;
    }

    public TransactionFilterBuilder withAccounts(List<String> accounts) {
        this.accounts = accounts;
        return this;
    }

    public TransactionFilterBuilder withCategories(List<String> categories) {
        this.categories = categories;
        return this;
    }

    public TransactionFilterBuilder withPayees(List<String> payees) {
        this.payees = payees;
        return this;
    }

    public TransactionFilter build() {
        return new TransactionFilter(startDate, endDate, accounts, categories, payees);
    }
}