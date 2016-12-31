package com.wyldkat.expman.dto.mapper;

import com.google.common.collect.Lists;
import com.wyldkat.expman.dto.SearchableEntitiesDto;
import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.model.Category;
import com.wyldkat.expman.model.Payee;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Jos&eacute; Batista on 31/12/2016.
 */
@Component
public class MetadataDtoMapper {

    public SearchableEntitiesDto mapEntityListsToDto(List<Account> accountList, List<Category> categoryList, List<Payee> payeeList) {
        SearchableEntitiesDto dto = new SearchableEntitiesDto();

        dto.setAccountNames(Lists.transform(accountList, Account::getName));
        dto.setCategoryNames(Lists.transform(categoryList, Category::getName));
        dto.setPayeeNames(Lists.transform(payeeList, Payee::getName));

        return dto;
    }
}
