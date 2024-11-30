package com.spring.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class UserController {
	
	

	@GetMapping
	public String userDashboard( Principal principal,Authentication authentication) {// 1st get the current logged in user 
		
		// Principal is parent interface ,while Authentication is child interface
		
		
		//2nd  get the current logged in user 
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return "This is User page--->"+name+"===>"+principal.getName()+"===>"+authentication;
	}

}
