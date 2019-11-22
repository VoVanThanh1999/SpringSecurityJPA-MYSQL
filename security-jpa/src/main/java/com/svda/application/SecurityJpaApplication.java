package com.svda.application;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.svda.entites.Roles;
import com.svda.entites.User;
import com.svda.repository.UserRepository;


@EntityScan("com.svda.entites")
@ComponentScan("com.svda.resources")
@ComponentScan("com.svda.config")
@ComponentScan("com.svda.service")
@EnableJpaRepositories("com.svda.repository")
@SpringBootApplication
public class SecurityJpaApplication implements CommandLineRunner{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SecurityJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		User user = new User();
//		user.setEmail("user@yahoo.com");
//		user.setPassword(passwordEncoder.encode("123456"));
//		Roles role = new Roles();
//		role.setRoleName("ROLE_USER");
//		Set<Roles> roles = new HashSet<Roles>();
//		roles.add(role);
//		user.setRoles(roles);
//		
//		userRepository.save(user);
	}

}
