package com.wyldkat.expman.model;

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

    private TransactionFilter(ZonedDateTime startDate, ZonedDateTime endDate, List<String> accounts, List<String> categories, List<String> payees) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.accounts = accounts;
        this.categories = categories;
        this.payees = payees;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public List<String> getCategories() {
        if (categories == null) {
            categories = new ArrayList<>();
        }

        return categories;
    }

    public List<String> getPayees() {
        if (payees == null) {
            payees = new ArrayList<>();
        }

        return payees;
    }

    public List<String> getAccounts() {
        if (accounts == null) {
            accounts = new ArrayList<>();
        }

        return accounts;
    }

    public static class TransactionFilterBuilder {
        private ZonedDateTime startDate;
        private ZonedDateTime endDate;
        private List<String> accounts;
        private List<String> categories;
        private List<String> payees;

        public TransactionFilterBuilder(ZonedDateTime startDate, ZonedDateTime endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
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
}
