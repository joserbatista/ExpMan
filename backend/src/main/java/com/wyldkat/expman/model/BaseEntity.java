package com.wyldkat.expman.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import java.time.ZonedDateTime;

@MappedSuperclass
public abstract class BaseEntity implements Comparable<BaseEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_date", updatable = false)
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @Column(name = "update_date")
    private ZonedDateTime updatedDate = ZonedDateTime.now();

    @PreUpdate
    public void setLastUpdate() {
        updatedDate = ZonedDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public ZonedDateTime getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public int compareTo(BaseEntity o) {
        return id.compareTo(o.id);
    }

}
