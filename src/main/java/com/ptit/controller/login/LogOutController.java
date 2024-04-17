package com.ptit.controller.login;

import com.ptit.Dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
@AllArgsConstructor
@SessionAttributes
public class LogOutController {
    @ModelAttribute("userdto")
    public UserDto userDto(){
        return new UserDto();
    }

    @GetMapping("/logout")
    public String Logout (@ModelAttribute("userdto") UserDto userDto, WebRequest request, SessionStatus status){
        status.setComplete();
        request.removeAttribute("userdto",WebRequest.SCOPE_SESSION);
        return "redirect:/user/home/page/1";
    }
}
