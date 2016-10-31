package com.wyldkat.expman.repository;

import com.wyldkat.expman.model.OwnedBaseEntity;
import com.wyldkat.expman.model.User;

import java.util.List;

/**
 * Created by Jos&eacute; Batista on 01/11/2016.
 */
public interface IOwnedEntityRepository<E extends OwnedBaseEntity> {
    List<E> findByOwner(User user);

    E findOneByOwnerAndId(User user, Long id);

    <T extends E> T save(E entity);

    void delete(E e);
}
