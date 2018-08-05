package com.wyldkat.expman.controller;

import com.wyldkat.expman.dto.TransactionDto;
import com.wyldkat.expman.dto.TransactionFilterDto;
import com.wyldkat.expman.dto.TransactionListDto;
import com.wyldkat.expman.dto.mapper.TransactionDtoMapper;
import com.wyldkat.expman.exception.InvalidParameterException;
import com.wyldkat.expman.model.Transaction;
import com.wyldkat.expman.model.TransactionFilter;
import com.wyldkat.expman.modules.security.JwtTokenUtil;
import com.wyldkat.expman.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/user/transaction")
public class TransactionController extends BaseOwnedEntityController<Transaction, TransactionDto, TransactionDtoMapper, ITransactionService> {

    private final JwtTokenUtil jwtTokenUtil;
    private final ITransactionService service;
    private final TransactionDtoMapper mapper;

    @Autowired
    public TransactionController(JwtTokenUtil jwtTokenUtil, ITransactionService service, TransactionDtoMapper mapper) {
        super(mapper, service, jwtTokenUtil);
        this.jwtTokenUtil = jwtTokenUtil;
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping(value = "filter")
    public ResponseEntity<TransactionListDto> getCurrentUserEntityListByFilter(HttpServletRequest request, @RequestBody TransactionFilterDto transactionFilterDto) {

        if (transactionFilterDto == null || !transactionFilterDto.hasValues()) {
            throw new InvalidParameterException("Filter must not be null");
        }

        String username = jwtTokenUtil.getUsernameFromRequest(request);

        TransactionFilter transactionFilter = mapper.mapDtoFilterToEntity(transactionFilterDto);
        List<Transaction> transactionList = service.loadAllByOwnerAndFilter(username, transactionFilter);

        TransactionListDto response = new TransactionListDto();
        response.setTransactions(mapper.mapEntityListToDtoList(transactionList));

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<TransactionDto>> getCurrentUserEntityList(HttpServletRequest request) {
        throw new UnsupportedOperationException("Get should be called with a filter");
    }
}
