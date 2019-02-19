package com.wyldkat.expman.service;

import com.wyldkat.expman.exception.InternalServerErrorException;
import com.wyldkat.expman.exception.InvalidParameterException;
import com.wyldkat.expman.model.OwnedBaseEntity;
import com.wyldkat.expman.model.User;
import com.wyldkat.expman.repository.IOwnedEntityRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public class OwnedEntityService<E extends OwnedBaseEntity, R extends IOwnedEntityRepository<E>> implements IOwnedEntityService<E> {

    private final R repository;
    private IUserService userDetailsService;

    OwnedEntityService(R repository, IUserService userDetailsService) {
        this.repository = repository;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public List<E> loadAllByOwner(String username) {
        User user = getUser(username);

        return repository.findByOwner(user);
    }

    @Override
    public E saveForUser(E entity, String username) {
        User user = getUser(username);

        entity.setOwner(user);

        this.loadByOwnerAndId(username, entity.getId())
            .orElseThrow(() -> new InvalidParameterException("Entity does not exist for user"));

        E saved = repository.save(entity);

        return Optional.ofNullable(saved).
            orElseThrow(() -> new InternalServerErrorException("Entity could not be saved!"));
    }

    @Override
    public Optional<E> loadByOwnerAndId(String username, Long id) {

        User user = getUser(username);

        return Optional.ofNullable(repository.findOneByOwnerAndId(user, id));
    }

    @Override
    public E createForUser(E entity, String username) {
        User user = getUser(username);

        entity.setOwner(user);

        E saved = repository.save(entity);

        return Optional.ofNullable(saved).
            orElseThrow(() -> new InternalServerErrorException("Entity could not be saved!"));
    }

    @Override
    public void removeForUser(Long id, String username) {
        repository.delete(this.loadByOwnerAndId(username, id)
                              .orElseThrow(InvalidParameterException::new));
    }

    User getUser(String username) {
        Optional<User> user = userDetailsService.loadDomainUserByUsername(username);

        if (!user.isPresent()) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
        return user.get();
    }
}
