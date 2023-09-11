package com.full.fullstackbackend.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(generator="user_seq", strategy = GenerationType.TABLE)
    @SequenceGenerator(name = "user_seq", sequenceName="user_sequence", initialValue = 1, allocationSize = 1)
    private Long id;
    private String username;
    private String name;
    private String email;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
