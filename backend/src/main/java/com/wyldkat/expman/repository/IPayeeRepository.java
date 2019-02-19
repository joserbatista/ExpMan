package com.wyldkat.expman.repository;

import com.wyldkat.expman.model.Payee;
import com.wyldkat.expman.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Jos&eacute; Batista on 01/11/2016.
 */
public interface IPayeeRepository extends CrudRepository<Payee, Long>, IOwnedEntityRepository<Payee> {

    /**
     * Find all payees owned by a certain user
     *
     * @param owner the payee owner
     * @return a list of payees which owner is the user specified. If no payees are found, this method returns an empty list
     */
    List<Payee> findByOwner(User owner);

    /**
     * Find the payee with the specified id for the specified owner
     *
     * @param user the payee owner
     * @param id   the id of the payee to retrieve
     * @return the payee found on the database. If no payee is found, this method returns null
     */
    Payee findOneByOwnerAndId(User user, Long id);

    /**
     * Save an payee with the specified parameters
     *
     * @param payee the payee to save for user
     * @return the saved payee
     */
    @SuppressWarnings("unchecked")
    @Override
    Payee save(Payee payee);

    /**
     * Delete an payee with the specified parameters
     */
    @SuppressWarnings("unchecked")
    @Override
    void delete(Payee payee);

    /**
     * Find the payee with the specified name for the specified owner
     *
     * @param user the payee owner
     * @param name the id of the payee to retrieve
     * @return the payee found on the database. If no payee is found, this method returns null
     */
    Payee findOneByOwnerAndName(User user, String name);
}
