package com.accenture.flowershop.be.access.user;

import com.accenture.flowershop.be.entity.user.User;

import java.util.List;

public interface UserDAO {
    //Сохраняет/добавляет юзера
    void addUser(User user);

    //поиск юзера по id
    User findUserById(long userId);

    //поиск юзера по логину
    User findUserByUsername(String username);

    //возврат всех юзеров
    List<User> getAllUsers();

}
