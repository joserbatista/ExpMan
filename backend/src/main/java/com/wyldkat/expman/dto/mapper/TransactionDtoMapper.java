package com.wyldkat.expman.dto.mapper;

import com.wyldkat.expman.dto.DtoMapper;
import com.wyldkat.expman.dto.TransactionDto;
import com.wyldkat.expman.dto.TransactionFilterDto;
import com.wyldkat.expman.model.Transaction;
import com.wyldkat.expman.model.TransactionFilter;
import com.wyldkat.expman.model.builder.TransactionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by Jos&eacute; Batista on 01/11/2016.
 */
@Component
public class TransactionDtoMapper implements DtoMapper<TransactionDto, Transaction> {

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
    public Optional<Transaction> mapDtoToEntity(TransactionDto transactionDto) {
        TransactionBuilder builder = new TransactionBuilder(Long.valueOf(transactionDto.getId()));

        accountDtoMapper.mapSimpleDtoToEntity(transactionDto.getAccount())
                        .ifPresent(builder::withAccount);

        categoryDtoMapper.mapDtoToEntity(transactionDto.getCategory())
                         .ifPresent(builder::withCategory);

        payeeDtoMapper.mapDtoToEntity(transactionDto.getPayee())
                      .ifPresent(builder::withPayee);

        return Optional.ofNullable(builder.withAmount(transactionDto.getAmount())
                                          .withDate(transactionDto.getDate() != null ? ZonedDateTime.parse(transactionDto.getDate()) : null)
                                          .withNote(transactionDto.getNote())
                                          .build());
    }

    @Override
    public Optional<TransactionDto> mapEntityToDto(Transaction transaction) {
        String id = String.valueOf(transaction.getId());

        TransactionDto.TransactionDtoBuilder builder = new TransactionDto.TransactionDtoBuilder(id);

        accountDtoMapper.mapEntityToSimpleDto(transaction.getAccount())
                        .ifPresent(builder::withAccount);

        categoryDtoMapper.mapEntityToDto(transaction.getCategory())
                         .ifPresent(builder::withCategory);

        payeeDtoMapper.mapEntityToDto(transaction.getPayee())
                      .ifPresent(builder::withPayee);

        TransactionDto transactionDto = builder.withAmount(transaction.getAmount())
                                               .withDate(transaction.getDate() != null ?
                                                             transaction.getDate().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME) : null)
                                               .withNote(transaction.getNote()).build();

        return Optional.ofNullable(transactionDto);
    }

    public TransactionFilter mapDtoFilterToEntity(TransactionFilterDto filterDto) {
        TransactionFilter.TransactionFilterBuilder builderWithDefaultDates = initBuilderWithDefaultDates(filterDto);

        if (!CollectionUtils.isEmpty(filterDto.getCategoryNames())) {
            builderWithDefaultDates.withCategories(new ArrayList<>(filterDto.getCategoryNames()));
        }

        if (!CollectionUtils.isEmpty(filterDto.getPayeeNames())) {
            builderWithDefaultDates.withPayees(new ArrayList<>(filterDto.getPayeeNames()));
        }

        if (!CollectionUtils.isEmpty(filterDto.getAccountNames())) {
            builderWithDefaultDates.withAccounts(new ArrayList<>(filterDto.getAccountNames()));
        }

        return builderWithDefaultDates.build();
    }

    private TransactionFilter.TransactionFilterBuilder initBuilderWithDefaultDates(TransactionFilterDto filterDto) {
        ZonedDateTime startDate;
        if (filterDto.getStartDate() == null) {
            startDate = ZonedDateTime.now().withDayOfMonth(1);
        } else {
            startDate = ZonedDateTime.parse(filterDto.getStartDate(), DateTimeFormatter.ISO_ZONED_DATE_TIME);
        }

        ZonedDateTime endDate;
        if (filterDto.getEndDate() == null) {
            endDate = ZonedDateTime.now();
        } else {
            endDate = ZonedDateTime.parse(filterDto.getEndDate(), DateTimeFormatter.ISO_ZONED_DATE_TIME);
        }

        return new TransactionFilter.TransactionFilterBuilder(startDate, endDate);
    }
}
