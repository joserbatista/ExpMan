package com.wyldkat.expman.dto.mapper;

import com.google.common.base.Strings;
import com.wyldkat.expman.dto.DtoMapper;
import com.wyldkat.expman.dto.IdAndValueDto;
import com.wyldkat.expman.model.Payee;
import org.springframework.stereotype.Component;

/**
 * Created by joseb on 01/11/2016.
 */
@Component
public class PayeeDtoMapper extends DtoMapper<IdAndValueDto, Payee> {
    @Override
    public Payee mapDtoToEntity(IdAndValueDto idAndValueDto) {
        Payee payee = new Payee();
        payee.setName(idAndValueDto.getValue());
        String id = idAndValueDto.getId();

        if (!Strings.isNullOrEmpty(id)) {
            payee.setId(Long.valueOf(id));

        }

        return payee;
    }

    @Override
    public IdAndValueDto mapEntityToDto(Payee payee) {
        if (payee == null) {
            return null;
        }
        return new IdAndValueDto(String.valueOf(payee.getId()), payee.getName());
    }
}
