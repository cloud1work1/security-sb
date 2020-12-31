package com.javabrains.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public String hello() {
		return "<h1>Hello Security</h1>";
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h1>Accessible with Admin and User Roles</h1>";
	} 
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Accessible with Admin Role</h1>";
	} 
}
