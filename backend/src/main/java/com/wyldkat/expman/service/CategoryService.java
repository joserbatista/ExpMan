package com.wyldkat.expman.service;


import com.wyldkat.expman.model.Category;
import com.wyldkat.expman.model.User;
import com.wyldkat.expman.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryService extends OwnedEntityService<Category, ICategoryRepository> implements ICategoryService {

    private final ICategoryRepository repository;

    @Autowired
    public CategoryService(ICategoryRepository repository, IUserService userDetailsService) {
        super(repository, userDetailsService);
        this.repository = repository;
    }

    @Override
    public Category loadByOwnerAndName(User user, String name) {
        return repository.findOneByOwnerAndName(user, name);
    }
}
