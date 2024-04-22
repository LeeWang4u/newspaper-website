package com.ptit.controller.admin;

import com.ptit.Dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
@SessionAttributes("userdto")
public class HomeAdminController {
    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }

     @GetMapping("/home")
    public String Home(){return "admin/home";}
    @GetMapping("/post")
    public String Post(){return "admin/postAdmin";}
    @GetMapping("/comment")
    public String Comment(){

        return "admin/comment";
    }
}

