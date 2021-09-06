package com.app.projectb.service;

import com.app.projectb.entity.AppRoles;
import com.app.projectb.entity.AppUser;
import com.app.projectb.repo.AppRolesRepository;
import com.app.projectb.repo.AppUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final AppUserRepository userRepo;
    private final AppRolesRepository rolesRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(AppUserRepository userRepo,
                           AppRolesRepository rolesRepo,
                           PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.rolesRepo = rolesRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepo.findByUsername(username);
        if(username == null){
            throw new UsernameNotFoundException("User not found in the database");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(), authorities);
    }

    @Override
    public AppUser saveUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return userRepo.save(appUser);
    }

    @Override
    public AppRoles saveRole(AppRoles appRoles) {
        return rolesRepo.save(appRoles);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = userRepo.findByUsername(username);
        AppRoles appRoles = rolesRepo.findByName(roleName);
        appUser.getRoles().add(appRoles);
    }

    @Override
    public AppUser getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        return userRepo.findAll();
    }
}
