package com.bjit.training.springsecurity2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/user")
	public String user(){
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin(){
		return "admin";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}

}
