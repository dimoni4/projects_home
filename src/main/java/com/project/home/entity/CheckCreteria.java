package com.project.home.entity;

/**
 * Created by dvetrov on 21/07/15.
 */
public enum CheckCreteria {
    SEARCH_WORD, HTTP_RESPONSE_CODE;

    private String value;

    public String getValue() {
        return value;
    }

    public CheckCreteria setValue(String value) {
        this.value = value;
        return this;
    }
}
