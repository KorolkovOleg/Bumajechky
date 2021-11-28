package com.bumajechky.domain;

import com.bumajechky.security.Authority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    private Long id;
    private String username;
    private String password;
    private Set<Pack> packages = new HashSet<>();
    private Set<Authority> authorities = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(     name = "user_package",
                    joinColumns = { @JoinColumn(name = "user_id")},
                    inverseJoinColumns = { @JoinColumn(name = "package_id")}
    )
    public Set<Pack> getPackages() {
        return packages;
    }

    public void setPackages(Set<Pack> packages) {
        this.packages = packages;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", packages=" + packages +
                ", authorities=" + authorities +
                '}';
    }
}
