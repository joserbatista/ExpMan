package com.wyldkat.expman.dto;

public class IdOnlyDto extends BaseDto {

    private String id;

    public IdOnlyDto(String id) {
        this.id = id;
    }

    public IdOnlyDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
