package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HomeController {
	
	
	
	@GetMapping
	public String publicHome()
	{
		System.out.println("this is public page ");
		return "This is public url";
	}
	
	
	
	
	
	
}
