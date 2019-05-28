package com.accenture.flowershop.fe.servlets.user;

import com.accenture.flowershop.be.business.user.UserBusinessService;
import com.accenture.flowershop.be.entity.user.User;
import com.accenture.flowershop.fe.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterRervlet extends HttpServlet {

    @Autowired
    UserBusinessService userBusinessService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/html; charset=UTF-8");
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setUsername(username);
        userDTO.setPassword(password);

        User user = userBusinessService.register(userDTO);
        if(user == null){//значит, что такой логин уже есть
            //кидаем ошибку и перенаправляем на сраничку логина опять
        }
        //иначе возвратит зарегистрированного юзера
        else {//установим в сессию
            HttpSession session = req.getSession();
            session.setAttribute("user", userDTO);
            //перенаправляем на домашнюю страничку
        }

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
