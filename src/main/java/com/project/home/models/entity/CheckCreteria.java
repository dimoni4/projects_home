package com.project.home.models.entity;

/**
 * Created by dvetrov on 21/07/15.
 */
public class CheckCreteria {
    private String checkWord;
    private Type checkType;

    public CheckCreteria() {
    }

    public CheckCreteria(Type type, String checkWord) {
        this.checkType = type;
        this.checkWord = checkWord;
    }

    public String getCheckWord() {
        return checkWord;
    }

    public Type getType() {
        return checkType;
    }

    public static enum Type {
        NONE, SEARCH_WORD, HTTP_RESPONSE_CODE
    }
}


