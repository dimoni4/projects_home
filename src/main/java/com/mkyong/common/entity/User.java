package com.mkyong.common.entity;

/**
 * Created by dvetrov on 03/04/15.
 */
public class User {
    private FightStatus fightStatus;
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
        return fightStatus == FightStatus.SEARCH;
    }

    public boolean isInFight() {
        return fightStatus == FightStatus.FIGHT;
    }

    public FightStatus getFightStatus() {
        return fightStatus;
    }

    public void setFightStatus(FightStatus fightStatus) {
        this.fightStatus = fightStatus;
    }
}
