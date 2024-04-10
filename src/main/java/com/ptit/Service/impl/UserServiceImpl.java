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
        User user = new User(userDto.getEmail(),userDto.getUserName(),userDto.getPassWord(),"ROLE_USER");
        userRepository.save(user);
    }

    @Override
    public Boolean checkPassWordUser(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if (user.getPassWord().equals(password)) return true;
        return false;
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
