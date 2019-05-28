package com.accenture.flowershop.be.business.user;

import com.accenture.flowershop.be.access.user.UserDAO;
import com.accenture.flowershop.be.business.jms.JmsService;
import com.accenture.flowershop.be.business.user.Marshalling.UserMarshallingServiceImpl;
import com.accenture.flowershop.be.entity.customer.Customer;
import com.accenture.flowershop.be.entity.user.User;
import com.accenture.flowershop.fe.dto.user.UserDTO;
import com.accenture.flowershop.fe.enums.User.UserRole;
import org.apache.cxf.helpers.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

@Service
public class UserBusinessServiceImpl implements UserBusinessService {

    @Autowired
    private UserDAO userDAO;


    @Transactional
    @Override
    public User register(UserDTO userDTO) {
        User user = userDAO.findUserByUsername(userDTO.getUsername());
        if (user != null) {
            return null;
            //ошибка что юзер с таким логином уже есть
        }
        user = new User();
        user.setRole(UserRole.CUSTOMER);
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());


        Customer customer = new Customer();
        //начальный баланс
        customer.setBalance(new BigDecimal(2000));
        customer.setUser(user);
        user.setCustomer(customer);

        userDAO.addUser(user);
        return user;
    }

    @Override
    public User login(String username, String password) {
        User user = userDAO.findUserByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null; //значит такой юзер не найден
    }

    @Override//
    public User findUserById(long userId) {
        return userDAO.findUserById(userId);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDAO.findUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDAO.getAllUsers();
        return users;
    }


}