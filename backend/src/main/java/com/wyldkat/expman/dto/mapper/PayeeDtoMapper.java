package com.wyldkat.expman.dto.mapper;

import com.google.common.base.Strings;
import com.wyldkat.expman.dto.DtoMapper;
import com.wyldkat.expman.dto.IdAndValueDto;
import com.wyldkat.expman.model.Payee;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by joseb on 01/11/2016.
 */
@Component
public class PayeeDtoMapper implements DtoMapper<IdAndValueDto, Payee> {
    @Override
    public Optional<Payee> mapDtoToEntity(IdAndValueDto idAndValueDto) {
        Payee payee = new Payee();
        payee.setName(idAndValueDto.getValue());
        String id = idAndValueDto.getId();

        if (!Strings.isNullOrEmpty(id)) {
            payee.setId(Long.valueOf(id));

        }

        return Optional.of(payee);
    }

    @Override
    public Optional<IdAndValueDto> mapEntityToDto(Payee payee) {
        if (payee == null) {
            return Optional.empty();
        }

        IdAndValueDto idAndValueDto = new IdAndValueDto(String.valueOf(payee.getId()), payee.getName());

        return Optional.of(idAndValueDto);
    }
}
