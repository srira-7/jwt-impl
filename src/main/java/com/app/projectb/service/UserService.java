package com.app.projectb.service;

import com.app.projectb.entity.AppRoles;
import com.app.projectb.entity.AppUser;

import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser appUser);
    AppRoles saveRole(AppRoles appRole);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
