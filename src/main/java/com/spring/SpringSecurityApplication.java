package com.spring;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.model.Role;
import com.spring.model.User;
import com.spring.repo.RoleRepository;
import com.spring.repo.UserRepository;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {
	
	


	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Radhey Radhey...");
		
		
		
		//userRepository.save(user);
		
	}

}
