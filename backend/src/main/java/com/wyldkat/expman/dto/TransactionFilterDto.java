package com.wyldkat.expman.dto;

import com.google.common.base.Strings;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by Jos&eacute; Batista on 01/11/2016.
 */
public class TransactionFilterDto {
    private String startDate;
    private String endDate;
    private List<String> accountNames;
    private List<String> categoryNames;
    private List<String> payeeNames;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<String> getCategoryNames() {
        return categoryNames;
    }

    public void setCategoryNames(List<String> categoryNames) {
        this.categoryNames = categoryNames;
    }

    public List<String> getPayeeNames() {
        return payeeNames;
    }

    public void setPayeeNames(List<String> payeeNames) {
        this.payeeNames = payeeNames;
    }

    public List<String> getAccountNames() {
        return accountNames;
    }

    public void setAccountNames(List<String> accountNames) {
        this.accountNames = accountNames;
    }

    public boolean hasValues() {
        if (!Strings.isNullOrEmpty(startDate)) {
            return true;
        }

        if (!Strings.isNullOrEmpty(endDate)) {
            return true;
        }

        if (!CollectionUtils.isEmpty(accountNames)) {
            return true;
        }

        if (!CollectionUtils.isEmpty(categoryNames)) {
            return true;
        }

        return !CollectionUtils.isEmpty(payeeNames);

    }
}
