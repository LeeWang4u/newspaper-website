package com.ptit.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class HomeController {
	@GetMapping("/home")
	public String home( ) {
		return "user/home";
	}
	@GetMapping("/post")
	public String post(){
		return "user/post";
	}
}

