package com.wyldkat.expman.dto.mapper;

import com.google.common.base.Strings;
import com.wyldkat.expman.dto.DtoMapper;
import com.wyldkat.expman.dto.IdAndValueDto;
import com.wyldkat.expman.dto.TransactionDto;
import com.wyldkat.expman.dto.TransactionFilterDto;
import com.wyldkat.expman.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by Jos&eacute; Batista on 01/11/2016.
 */
@Component
public class TransactionDtoMapper extends DtoMapper<TransactionDto, Transaction> {

    private AccountDtoMapper accountDtoMapper;
    private CategoryDtoMapper categoryDtoMapper;
    private PayeeDtoMapper payeeDtoMapper;

    @Autowired
    public TransactionDtoMapper(AccountDtoMapper accountDtoMapper, CategoryDtoMapper categoryDtoMapper, PayeeDtoMapper payeeDtoMapper) {
        this.accountDtoMapper = accountDtoMapper;
        this.categoryDtoMapper = categoryDtoMapper;
        this.payeeDtoMapper = payeeDtoMapper;
    }

    @Override
    public Transaction mapDtoToEntity(TransactionDto transactionDto) {
        TransactionBuilder builder = new TransactionBuilder(Long.valueOf(transactionDto.getId()));

        return builder.
                withAccount(accountDtoMapper.mapSimpleDtoToEntity(transactionDto.getAccount())).
                withAmount(transactionDto.getAmount()).
                withCategory(categoryDtoMapper.mapDtoToEntity(transactionDto.getCategory())).
                withDate(transactionDto.getDate() != null ? ZonedDateTime.parse(transactionDto.getDate()) : null).
                withNote(transactionDto.getNote()).
                withPayee(payeeDtoMapper.mapDtoToEntity(transactionDto.getPayee())).build();
    }

    @Override
    public TransactionDto mapEntityToDto(Transaction transaction) {
        TransactionDtoBuilder builder = new TransactionDtoBuilder(String.valueOf(transaction.getId()));

        return builder.
                withAccount(accountDtoMapper.mapEntityToSimpleDto(transaction.getAccount())).
                withAmount(transaction.getAmount()).
                withCategory(categoryDtoMapper.mapEntityToDto(transaction.getCategory())).
                withDate(transaction.getDate() != null ? transaction.getDate().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME) : null).
                withNote(transaction.getNote()).
                withPayee(payeeDtoMapper.mapEntityToDto(transaction.getPayee())).build();
    }

    public TransactionFilter mapDtoFilterToEntity(TransactionFilterDto filterDto) {
        TransactionFilter filter = new TransactionFilter();

        List<Category> categories = filter.getCategories();
        List<Payee> payees = filter.getPayees();

        if (filterDto.getCategoryNames() != null) {
            filterDto.getCategoryNames().stream().filter(category -> !Strings.isNullOrEmpty(category)).forEach(
                    category -> categories.add(categoryDtoMapper.mapDtoToEntity(new IdAndValueDto(null, category))));
        }

        if (filterDto.getPayeeNames() != null) {
            filterDto.getPayeeNames().stream().filter(payee -> !Strings.isNullOrEmpty(payee)).forEach(
                    payee -> payees.add(payeeDtoMapper.mapDtoToEntity(new IdAndValueDto(null, payee))));
        }

        filter.setStartDate(filter.getStartDate());
        filter.setEndDate(filter.getEndDate());
        return filter;
    }
}
