package com.ptit.Service;

import com.ptit.Dto.UserDto;
import com.ptit.Entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(UserDto userDto);
    Boolean checkPasswordUser(String email, String password);
    Boolean checkUserByEmail(String email);
    User getUserByEmail(String email);
}
