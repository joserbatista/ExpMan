package com.wyldkat.expman.controller;

import com.wyldkat.expman.dto.SearchableEntitiesDto;
import com.wyldkat.expman.dto.mapper.MetadataDtoMapper;
import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.model.Category;
import com.wyldkat.expman.model.Payee;
import com.wyldkat.expman.modules.security.JwtTokenUtil;
import com.wyldkat.expman.service.IAccountService;
import com.wyldkat.expman.service.ICategoryService;
import com.wyldkat.expman.service.IPayeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Jos&eacute; Batista on 31/12/2016.
 */

@RestController

@RequestMapping("api/user/metadata")
public class MetadataController {

    private final IAccountService accountService;
    private final ICategoryService categoryService;
    private final IPayeeService payeeService;
    private final MetadataDtoMapper mapper;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public MetadataController(IAccountService accountService, ICategoryService categoryService, IPayeeService payeeService, MetadataDtoMapper mapper,
        JwtTokenUtil jwtTokenUtil) {
        this.accountService = accountService;
        this.categoryService = categoryService;
        this.payeeService = payeeService;
        this.mapper = mapper;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping(value = "searchableEntities")
    public ResponseEntity<SearchableEntitiesDto> getSearchableEntities(HttpServletRequest request) {

        String username = jwtTokenUtil.getUsernameFromRequest(request);
        List<Account> accountList = accountService.loadAllByOwner(username);
        List<Category> categoryList = categoryService.loadAllByOwner(username);
        List<Payee> payeeList = payeeService.loadAllByOwner(username);

        return ResponseEntity.ok(mapper.mapEntityListsToDto(accountList, categoryList, payeeList));
    }
}
