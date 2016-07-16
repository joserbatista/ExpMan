package com.wyldkat.expman.dto;

import com.wyldkat.expman.model.BaseEntity;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract class that declares methods to convert to and from a DTO
 *
 * @param <D> the DTO class
 * @param <E> the Entity class
 * @author José Batista
 */
public abstract class DtoMapper<D extends BaseDto, E extends BaseEntity> {
    public D mapEntityToDto(E e) {
        throw new UnsupportedOperationException();
    }

    public E mapDtoToEntity(D d) {
        throw new UnsupportedOperationException();
    }

    public List<D> mapEntityListToDtoList(List<E> e) {
        return e.stream().map(this::mapEntityToDto).collect(Collectors.toList());
    }

    public List<E> mapDtoListToEntityList(List<D> d) {
        return d.stream().map(this::mapDtoToEntity).collect(Collectors.toList());
    }
}
