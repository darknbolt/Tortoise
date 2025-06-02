package com.darknbolt.tortoise.Models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AppUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() { return id; }
    public void setUsername(String username) { this.username = username; }
    public String getUsername() { return username; }
    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return password; }
    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }
    public void setRoles(Set<UserRole> roles) { this.roles = roles; }
    public Set<UserRole> getRoles() { return roles; }
}
