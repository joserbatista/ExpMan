package com.wyldkat.expman.dto;

import com.wyldkat.expman.model.BaseEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Interface that declares methods to convert to and from a DTO and provides simple defaults
 *
 * @param <D> the DTO class
 * @param <E> the Entity class
 * @author José Batista
 */
public interface DtoMapper<D extends BaseDto, E extends BaseEntity> {

    E mapDtoToEntity(D d);

    D mapEntityToDto(E e);

    default List<D> mapEntityListToDtoList(List<E> e) {
        return e.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }

    default List<E> mapDtoListToEntityList(List<D> d) {
        return d.stream().map(this::mapDtoToEntity).collect(Collectors.toList());
    }

    default List<IdAndValueDto> mapEntityListToSimpleDtoList(List<E> e) {
        return e.stream().map(this::mapEntityToSimpleDto).collect(Collectors.toList());
    }

    default List<E> mapSimpleDtoListToEntityList(List<IdAndValueDto> d) {
        return d.stream().map(this::mapSimpleDtoToEntity).collect(Collectors.toList());
    }

    default E mapSimpleDtoToEntity(IdAndValueDto account) {
        throw new UnsupportedOperationException("You must implement mapSimpleDtoToEntity");
    }

    default IdAndValueDto mapEntityToSimpleDto(E e) {
        throw new UnsupportedOperationException("You must implement mapEntityToSimpleDto");
    }


}
