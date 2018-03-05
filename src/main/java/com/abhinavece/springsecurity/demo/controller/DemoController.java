package com.abhinavece.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {

		return "home";
	}

	@GetMapping("/showLoginPage")
	public String showLoginPage() {

		return "fancy-login";
	}
	
	@GetMapping("/leader")
	public String showLeaderPage() {

		return "leaders";
	}
	
	@GetMapping("/system")
	public String showSystemPage() {

		return "system";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {

		return "access-denied";
	}
	
}