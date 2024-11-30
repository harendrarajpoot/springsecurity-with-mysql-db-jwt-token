package com.spring.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	
	@GetMapping
	public String adminDashboard(Authentication authentication,Principal principal)
	{
		System.out.println(principal);
		System.out.println(authentication);
		
		return "this is admin page--->"+authentication+"======>"+principal;
	}
	

}
