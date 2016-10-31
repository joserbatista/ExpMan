package com.wyldkat.expman.dto;

/**
 * Created by joseb on 01/11/2016.
 */
public class IdAndValueDto extends IdOnlyDto {

    private String value;

    public IdAndValueDto() {
    }

    public IdAndValueDto(String id, String value) {
        super(id);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
