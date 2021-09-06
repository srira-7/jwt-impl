package com.app.projectb;

import com.app.projectb.entity.AppRoles;
import com.app.projectb.entity.AppUser;
import com.app.projectb.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class ProjectbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectbApplication.class, args);
	}

/*	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new AppRoles(null, "ROLE_ADMIN"));
			userService.saveRole(new AppRoles(null, "ROLE_USER"));

			userService.saveUser(new AppUser
					(null, "naruto", "rasengan", "naruto@konoha.com", true, new ArrayList<>()));
			userService.saveUser(new AppUser
					(null,"hinata", "byakugan", "hinata@konoha.com", true, new ArrayList<>()));

			userService.addRoleToUser("naruto", "ROLE_USER");
			userService.addRoleToUser("hinata", "ROLE_USER");
			userService.addRoleToUser("naruto", "ROLE_ADMIN");
		};
	}*/
}
