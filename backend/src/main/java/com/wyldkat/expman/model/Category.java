package com.wyldkat.expman.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by joseb on 31/10/2016.
 */
@Entity
@Table(name = "categories")
public class Category extends OwnedBaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
