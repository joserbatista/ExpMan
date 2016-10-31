package com.wyldkat.expman.controller;

import com.wyldkat.expman.dto.IdAndValueDto;
import com.wyldkat.expman.dto.mapper.CategoryDtoMapper;
import com.wyldkat.expman.model.Category;
import com.wyldkat.expman.modules.security.JwtTokenUtil;
import com.wyldkat.expman.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/category")
public class CategoryController extends BaseOwnedEntityController<Category, IdAndValueDto, CategoryDtoMapper, ICategoryService> {

    @Autowired
    public CategoryController(CategoryDtoMapper categoryMapper, ICategoryService categoryService, JwtTokenUtil jwtTokenUtil) {
        super(categoryMapper, categoryService, jwtTokenUtil);
    }

}
