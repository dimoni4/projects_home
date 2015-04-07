package com.mkyong.common.entity;

/**
 * Created by dvetrov on 03/04/15.
 */
public class User {
    private boolean wantFight;
    private String name;
    private int hitpoints;
    private int power;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isWantFight() {
        return wantFight;
    }

    public void setWantFight(boolean wantFight) {
        this.wantFight = wantFight;
    }
}
