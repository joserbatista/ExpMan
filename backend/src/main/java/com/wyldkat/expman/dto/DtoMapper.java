package com.wyldkat.expman.dto;

import com.wyldkat.expman.model.BaseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Interface that declares methods to convert to and from a DTO and provides simple defaults
 *
 * @param <D> the DTO class
 * @param <E> the Entity class
 * @author José Batista
 */
public interface DtoMapper<D extends BaseDto, E extends BaseEntity> {

    Optional<E> mapDtoToEntity(D d);

    Optional<D> mapEntityToDto(E e);

    default List<D> mapEntityListToDtoList(List<E> e) {
        return e.stream()
                .map(this::mapEntityToDto)
                .filter(Optional::isPresent).map(Optional::get)
                .collect(Collectors.toList());
    }

    default List<E> mapDtoListToEntityList(List<D> d) {
        return d.stream().map(this::mapDtoToEntity)
                .filter(Optional::isPresent).map(Optional::get)
                .collect(Collectors.toList());
    }

    default List<IdAndValueDto> mapEntityListToSimpleDtoList(List<E> e) {
        return e.stream().map(this::mapEntityToSimpleDto)
                .filter(Optional::isPresent).map(Optional::get)
                .collect(Collectors.toList());
    }

    default List<E> mapSimpleDtoListToEntityList(List<IdAndValueDto> d) {
        return d.stream().map(this::mapSimpleDtoToEntity)
                .filter(Optional::isPresent).map(Optional::get)
                .collect(Collectors.toList());
    }

    default Optional<E> mapSimpleDtoToEntity(IdAndValueDto account) {
        throw new UnsupportedOperationException("You must implement mapSimpleDtoToEntity");
    }

    default Optional<IdAndValueDto> mapEntityToSimpleDto(E e) {
        throw new UnsupportedOperationException("You must implement mapEntityToSimpleDto");
    }

}
