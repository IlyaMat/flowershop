package com.accenture.flowershop.be.business.user;

import com.accenture.flowershop.be.entity.user.User;
import com.accenture.flowershop.fe.dto.user.UserDTO;

import java.util.List;

public interface UserBusinessService {

    //регистрация
    User register(UserDTO userDTO);

    //вход
    User login(String username, String password);
    //User login(UserDTO userDTO);

    //поиск по id
    User findUserById(long userId);

    //поиск по логину
    User findUserByUsername(String username);

    List<User> getAllUsers();


}
