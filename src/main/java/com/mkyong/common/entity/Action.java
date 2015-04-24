package com.mkyong.common.entity;

/**
 * Created by dvetrov on 23/04/15.
 */
public class Action {
    private User subject;
    private ActionType type;
    private User object;

    public User getSubject() {
        return subject;
    }

    public void setSubject(User subject) {
        this.subject = subject;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public User getObject() {
        return object;
    }

    public void setObject(User object) {
        this.object = object;
    }
}
