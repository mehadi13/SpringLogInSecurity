package com.bjit.training.springsecurity2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RController {

	@GetMapping("/test")
	public String test(){
		return "tttttttttttttttttt";
	}
}
