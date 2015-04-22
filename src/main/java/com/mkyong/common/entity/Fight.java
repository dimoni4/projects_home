package com.mkyong.common.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dvetrov on 03/04/15.
 */
@Entity
@Table(name = "fight")
@NamedQueries({
        @NamedQuery (name = Fight.FIND_BY_USER, query = "select a from Fight a where :user MEMBER OF a.users")
})
public class Fight {
    public static final String FIND_BY_USER = "User.findByUser";

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fight")
    private List<User> users;

    public Fight() {
        this.users = new ArrayList<User>();
    }

    public User getEnemy(User currentUser) {
        User enemy = null;
        for (User user : users) {
            if(!currentUser.equals(user)) {
                enemy = user;
            }
        }
        return enemy;
    }

    public Fight addUser(User user) {
        users.add(user);
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
