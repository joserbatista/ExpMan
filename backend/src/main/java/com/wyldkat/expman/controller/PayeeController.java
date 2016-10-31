package com.wyldkat.expman.controller;

import com.wyldkat.expman.dto.IdAndValueDto;
import com.wyldkat.expman.dto.mapper.PayeeDtoMapper;
import com.wyldkat.expman.model.Payee;
import com.wyldkat.expman.modules.security.JwtTokenUtil;
import com.wyldkat.expman.service.IPayeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/payee")
public class PayeeController extends BaseOwnedEntityController<Payee, IdAndValueDto, PayeeDtoMapper, IPayeeService> {

    @Autowired
    public PayeeController(PayeeDtoMapper payeeMapper, IPayeeService payeeService, JwtTokenUtil jwtTokenUtil) {
        super(payeeMapper, payeeService, jwtTokenUtil);
    }

}
