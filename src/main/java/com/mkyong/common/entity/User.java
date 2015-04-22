package com.mkyong.common.entity;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
@NamedQueries ({
        @NamedQuery (name = User.FIND_BY_EMAIL, query = "select a from User a where a.email = :email"),
        @NamedQuery(name = User.FIND_BY_FIGHT_STATUS, query = "select a from User a where a.fightStatus = :fightStatus")
})
public class User implements java.io.Serializable {

    public static final String FIND_BY_EMAIL = "User.findByEmail";
    public static final String FIND_BY_FIGHT_STATUS = "User.fightStatus";

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;
    private String role;
    private FightStatus fightStatus;
    private int hitpoints;
    private int power;

    @ManyToOne(fetch = FetchType.EAGER)
    private Fight fight;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }


    public User(String email, String password, String role, FightStatus fightStatus, int hitpoints, int power) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.fightStatus = fightStatus;
        this.hitpoints = hitpoints;
        this.power = power;
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

    public Fight getFight() {
        return fight;
    }

    public void setFight(Fight fight) {
        this.fight = fight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
