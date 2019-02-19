package com.wyldkat.expman.service;

import java.util.List;
import java.util.Optional;

public interface IOwnedEntityService<E> {
    List<E> loadAllByOwner(String username);

    E saveForUser(E e, String username);

    Optional<E> loadByOwnerAndId(String username, Long id);

    E createForUser(E entity, String username);

    void removeForUser(Long id, String username);

}
