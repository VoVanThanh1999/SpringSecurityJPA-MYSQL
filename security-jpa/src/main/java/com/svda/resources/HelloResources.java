package com.svda.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResources {
	
	@GetMapping("/home")
	public String hello() {
		return "<h1> Hello Youtube </h1>";
	}
	
	@GetMapping("/admin")
	public String securedHello() {
		return "Secured Hello";
	}
}
