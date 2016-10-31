package com.wyldkat.expman.dto.mapper;

import com.google.common.base.Strings;
import com.wyldkat.expman.dto.DtoMapper;
import com.wyldkat.expman.dto.IdAndValueDto;
import com.wyldkat.expman.model.Category;
import org.springframework.stereotype.Component;

/**
 * Created by joseb on 01/11/2016.
 */
@Component
public class CategoryDtoMapper extends DtoMapper<IdAndValueDto, Category> {
    @Override
    public Category mapDtoToEntity(IdAndValueDto idAndValueDto) {
        Category category = new Category();
        category.setName(idAndValueDto.getValue());
        String id = idAndValueDto.getId();

        if (!Strings.isNullOrEmpty(id)) {
            category.setId(Long.valueOf(id));

        }

        return category;
    }

    @Override
    public IdAndValueDto mapEntityToDto(Category category) {
        if (category == null) {
            return null;
        }

        return new IdAndValueDto(String.valueOf(category.getId()), category.getName());
    }
}
