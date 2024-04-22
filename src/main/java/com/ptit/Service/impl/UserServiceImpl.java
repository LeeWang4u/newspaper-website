package com.ptit.Service.impl;

import com.ptit.Dto.UserDto;
import com.ptit.Entities.User;
import com.ptit.Repository.UserRepository;
import com.ptit.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(UserDto userDto){
        User user = new User(userDto.getUserName(),userDto.getEmail(),userDto.getPassWord(),"ROLE_USER");
        userRepository.save(user);
    }

    @Override
    public Boolean checkPassWordUser(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        System.out.println(user.getPassWord());
        System.out.println(password);
        System.out.println(user.getPassWord().trim().equals(password.trim()));
        if (user.getPassWord().trim().equals(password.trim())) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Boolean checkUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if(user==null) return false;
        return true;
    }
    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

}
