package com.ptit.controller.user;

import com.ptit.Dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
@SessionAttributes("userdto")
public class HomeController {
	@ModelAttribute("userdto")
	public UserDto userDto(){
		return new UserDto();
	}
	@GetMapping("/home")
	public String home(@ModelAttribute("userdto") UserDto userDto ) {
		return "user/home";
	}
	@GetMapping("/post")
	public String post(@ModelAttribute("userdto") UserDto userDto){
		return "user/post";
	}
}

