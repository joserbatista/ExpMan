package com.wyldkat.expman.service;

import com.wyldkat.expman.model.Payee;
import com.wyldkat.expman.model.User;
import com.wyldkat.expman.repository.IPayeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("payeeService")
public class PayeeService extends OwnedEntityService<Payee, IPayeeRepository> implements IPayeeService {

    private IPayeeRepository repository;

    @Autowired
    public PayeeService(IPayeeRepository repository, IUserService userDetailsService) {
        super(repository, userDetailsService);
        this.repository = repository;
    }

    @Override
    public Payee loadByOwnerAndName(User user, String name) {
        return repository.findOneByOwnerAndName(user, name);
    }
}
