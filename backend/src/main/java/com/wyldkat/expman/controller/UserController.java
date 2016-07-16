package com.wyldkat.expman.controller;

import com.wyldkat.expman.dto.UserDto;
import com.wyldkat.expman.dto.UserDtoMapper;
import com.wyldkat.expman.modules.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserDtoMapper userDtoMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<UserDto> getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        return ResponseEntity.ok(userDtoMapper.mapSecurityEntityToDto(userDetailsService.loadUserByUsername(username)));
    }

}
