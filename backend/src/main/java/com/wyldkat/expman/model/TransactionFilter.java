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
    private List<Category> categories;
    private List<Payee> payees;

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

    public List<Category> getCategories() {
        if (categories == null)
            categories = new ArrayList<>();

        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Payee> getPayees() {
        if (payees == null)
            payees = new ArrayList<>();

        return payees;
    }

    public void setPayees(List<Payee> payees) {
        this.payees = payees;
    }
}
