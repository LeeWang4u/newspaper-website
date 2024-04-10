package com.ptit.controller.login;

import com.ptit.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.ptit.Dto.UserDto;

@Controller
@AllArgsConstructor
public class SignUpController {
    private UserService userService;

    @ModelAttribute("userdto")
    public UserDto userSignUpDto(){
        return new UserDto();
    }

    @GetMapping("/signUp")
    public String showSignUpForm(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUpUserAccount(@ModelAttribute("userdto") UserDto userDto){
        if(userService.checkUserByEmail(userDto.getEmail())){
            return "redirect:/signUp?emailexist";
        }
        userService.save(userDto);
        return "redirect:/signUp?success";
    }
}
