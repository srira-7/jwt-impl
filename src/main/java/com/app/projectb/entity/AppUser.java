package com.app.projectb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String email;
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRoles> roles = new ArrayList<>();

    public AppUser(Long id,
                   String username,
                   String password,
                   String email,
                   boolean enabled,
                   Collection<AppRoles> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.roles = roles;
    }

    public AppUser() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<AppRoles> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRoles> roles) {
        this.roles = roles;
    }
}
