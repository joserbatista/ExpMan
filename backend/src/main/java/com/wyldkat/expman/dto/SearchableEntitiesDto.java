package com.wyldkat.expman.dto;

import java.util.List;

/**
 * Created by Jos&eacute; Batista on 31/12/2016.
 */
public class SearchableEntitiesDto {
    private List<String> accountNames;
    private List<String> categoryNames;
    private List<String> payeeNames;

    public List<String> getAccountNames() {
        return accountNames;
    }

    public void setAccountNames(List<String> accountNames) {
        this.accountNames = accountNames;
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
}
