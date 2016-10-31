package com.wyldkat.expman.service;

import com.wyldkat.expman.model.Payee;
import com.wyldkat.expman.model.User;

/**
 * Created by Jos&eacute; Batista on 01/11/2016.
 */
public interface IPayeeService extends IOwnedEntityService<Payee> {
    Payee loadByOwnerAndName(User username, String name);
}
