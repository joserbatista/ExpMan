package com.wyldkat.expman.controller;

import com.wyldkat.expman.model.Account;
import com.wyldkat.expman.modules.security.JwtTokenUtil;
import com.wyldkat.expman.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/user/account")
public class AccountController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private IAccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Account>> getCurrentUserAccount(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        return ResponseEntity.ok(accountService.loadAccountsByOwner(username));
    }

}
