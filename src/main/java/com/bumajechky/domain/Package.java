package com.bumajechky.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Package {

    private Long id;
    private String name;
    private Set<User> users;
    private Set<Card> cards;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "packages")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @OneToMany(mappedBy = "aPackage")
    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }
}
