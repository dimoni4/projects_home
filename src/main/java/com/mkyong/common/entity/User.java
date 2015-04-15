package com.mkyong.common.entity;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
@NamedQuery(name = User.FIND_BY_EMAIL, query = "select a from User a where a.email = :email")
public class User implements java.io.Serializable {

    public static final String FIND_BY_EMAIL = "Account.findByEmail";

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;
    private String role = "ROLE_USER";
    private FightStatus fightStatus;
    private int hitpoints;
    private int power;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }


    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.fightStatus = FightStatus.PEACE;
        this.hitpoints = 100;
        this.power = 20;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
