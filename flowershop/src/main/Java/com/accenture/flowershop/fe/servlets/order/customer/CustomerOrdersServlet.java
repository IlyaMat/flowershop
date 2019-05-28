package com.accenture.flowershop.fe.servlets.order.customer;

import com.accenture.flowershop.be.business.customer.CustomerBusinessService;
import com.accenture.flowershop.be.business.order.OrderBusinessService;
import com.accenture.flowershop.be.entity.customer.Customer;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.fe.dto.customer.CustomerDTO;
import com.accenture.flowershop.fe.dto.order.OrderDTO;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/myorders")
public class CustomerOrdersServlet extends HttpServlet {

    @Autowired
    private CustomerBusinessService customerBusinessService;
    @Autowired
    private OrderBusinessService orderBusinessService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int customerId = Integer.parseInt(req.getParameter("id"));
        Customer customer = customerBusinessService.findCustomerById(customerId);

        List<Order> orderList = orderBusinessService.findOrderByCustomer(customer);

        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Order order : orderList) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(order.getId());
            orderDTO.setTotalPrice(order.getTotalPrice());
            orderDTO.setCreatedAt(order.getCreatedAt());
            orderDTO.setClosedAt(order.getClosedAt());
            orderDTO.setStatus(order.getStatus());
            orderDTOList.add(orderDTO);
        }

        req.setAttribute("orders", orderDTOList);
        req.getRequestDispatcher("/myOrders.jsp").forward(req, resp);
    }

    @Override //оплачиваем
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long orderId = Long.parseLong(req.getParameter("orderId"));
        //Order order = orderBusinessService.findOrderById(orderId);
        HttpSession session = req.getSession();
        UserDTO userDTO = (UserDTO) session.getAttribute("user");

        Order order =  orderBusinessService.payOrder(orderId);
        userDTO.getCustomer().setBalance(order.getCustomer().getBalance());

        req.setAttribute("user",userDTO);
        //перенаправляем
        resp.sendRedirect("/products");

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
