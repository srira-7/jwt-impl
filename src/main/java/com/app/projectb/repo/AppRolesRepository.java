package com.app.projectb.repo;

import com.app.projectb.entity.AppRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRolesRepository extends JpaRepository<AppRoles, Long> {
    AppRoles findByName(String name);
}
