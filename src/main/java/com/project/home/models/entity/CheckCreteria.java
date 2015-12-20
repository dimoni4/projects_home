package com.project.home.models.entity;

/**
 * Created by dvetrov on 21/07/15.
 */
public class CheckCreteria {
    private String checkWord;
    private Type chekType;

    public CheckCreteria() {
    }

    public CheckCreteria(Type type, String checkWord) {
        this.chekType = type;
        this.checkWord = checkWord;
    }

    public String getCheckWord() {
        return checkWord;
    }

    public Type getType() {
        return chekType;
    }

    public static enum Type {
        SEARCH_WORD, HTTP_RESPONSE_CODE;
    }
}


