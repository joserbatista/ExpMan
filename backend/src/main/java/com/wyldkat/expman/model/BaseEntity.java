package com.wyldkat.expman.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity implements Comparable<BaseEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date", updatable = false)
    private Date createdDate = new Date();

    @Column(name = "update_date")
    private Date updatedDate = new Date();

    @PreUpdate
    public void setLastUpdate() {
        updatedDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public int compareTo(BaseEntity o) {
        return id.compareTo(o.id);
    }

}
