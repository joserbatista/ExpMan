package com.wyldkat.expman.repository;

import com.wyldkat.expman.model.Category;
import com.wyldkat.expman.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Jos&eacute; Batista on 01/11/2016.
 */
public interface ICategoryRepository extends CrudRepository<Category, Long>, IOwnedEntityRepository<Category> {

    /**
     * Find all categories owned by a certain user
     *
     * @param owner the category owner
     * @return a list of categories which owner is the user specified. If no categories are found, this method returns an empty list
     */
    List<Category> findByOwner(User owner);

    /**
     * Find the category with the specified id for the specified owner
     *
     * @param user the category owner
     * @param id   the id of the category to retrieve
     * @return the category found on the database. If no category is found, this method returns null
     */
    Category findOneByOwnerAndId(User user, Long id);

    /**
     * Save an category with the specified parameters
     *
     * @param category the category to save for user
     * @return the saved category
     */
    @Override
    Category save(Category category);

    /**
     * Delete an category with the specified parameters
     */
    @Override
    void delete(Category category);

    /**
     * Find the category with the specified name for the specified owner
     *
     * @param user the category owner
     * @param name the name of the category to retrieve
     * @return the category found on the database. If no category is found, this method returns null
     */
    Category findOneByOwnerAndName(User user, String name);
}
