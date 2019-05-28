package com.accenture.flowershop.fe.servlets.cart;

import com.accenture.flowershop.be.business.order.OrderBusinessService;
import com.accenture.flowershop.fe.dto.cart.FlowerItem;
import com.accenture.flowershop.fe.dto.order.OrderDTO;
import com.accenture.flowershop.fe.dto.user.UserDTO;
import com.accenture.flowershop.fe.enums.Order.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/cart")//и изменяем статус заказа на СОЗДАННЫЙ
public class CartServlet extends HttpServlet {

    @Autowired
    private OrderBusinessService orderBusinessService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        //получаем поля фомы
        String fullname = req.getParameter("fullname");
        String phoneNumber = req.getParameter("phoneNumber");
        String address = req.getParameter("address");
        UserDTO user = (UserDTO) session.getAttribute("user");
        //OrderDTO
        OrderDTO order = new OrderDTO();
        order.setCustomer(user.getCustomer());
        order.setTotalPrice(user.getCustomer().getCart().getTotalPriceWithDiscount());
        order.setCreatedAt(new Date());
        //order.setClosedAt();
        order.setStatus(OrderStatus.СОЗДАН);
        //
        orderBusinessService.createOrder(order);

    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    }
}
