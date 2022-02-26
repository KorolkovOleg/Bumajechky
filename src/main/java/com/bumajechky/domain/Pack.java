package com.bumajechky.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "package")
public class Pack {

    private Long id;
    private String name;
    private Set<User> users = new HashSet<>();
    private Set<Card> cards = new HashSet<>();

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(     name = "user_package",
                    joinColumns = { @JoinColumn(name = "package_id")},
                    inverseJoinColumns = { @JoinColumn(name = "user_id")}
    )
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @OneToMany(mappedBy = "pack", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Pack{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
