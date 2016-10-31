package com.wyldkat.expman.service;

import com.wyldkat.expman.model.Category;
import com.wyldkat.expman.model.User;

/**
 * Created by Jos&eacute; Batista on 01/11/2016.
 */
public interface ICategoryService extends IOwnedEntityService<Category> {

    Category loadByOwnerAndName(User user, String name);
}
