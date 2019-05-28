package com.accenture.flowershop.fe.servlets.order;

import com.accenture.flowershop.be.business.customer.CustomerBusinessService;
import com.accenture.flowershop.be.business.order.OrderBusinessService;
import com.accenture.flowershop.be.entity.customer.Customer;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.orderproduct.OrderProduct;
import com.accenture.flowershop.be.entity.product.Product;
import com.accenture.flowershop.fe.dto.customer.CustomerDTO;
import com.accenture.flowershop.fe.dto.order.OrderDTO;
import com.accenture.flowershop.fe.dto.orderproduct.OrderProductDTO;
import com.accenture.flowershop.fe.dto.product.ProductDTO;
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

@WebServlet("/orders")
public class AdminOrdersServlet extends HttpServlet {

    @Autowired
    OrderBusinessService orderBusinessService;
    @Autowired
    CustomerBusinessService customerBusinessService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //UserDTO userDTO = (UserDTO) session.getAttribute("user");

        List<Order> orderList = orderBusinessService.getAllOrders();
        List<OrderDTO> orderDTOList = new ArrayList<>();

        for (Order o : orderList) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setId(o.getId());
            orderDTO.setTotalPrice(o.getTotalPrice());
            orderDTO.setCreatedAt(o.getCreatedAt());
            orderDTO.setClosedAt(o.getCreatedAt());
            orderDTO.setStatus(o.getStatus());
            //customer
            Customer customer = customerBusinessService.findCustomerById(o.getCustomer().getId());
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setFullname(customer.getFullname());
            customerDTO.setPhoneNumber(customer.getPhoneNumber());
            customerDTO.setAddress(customer.getAddress());
            //

            // System.out.println("products.get(0).getName() = "  + orderDTO.getProductList().get(0).getName());
            orderDTO.setCustomer(customerDTO);
            orderDTOList.add(orderDTO);
        }

        req.setAttribute("orders", orderDTOList);
        //req.setAttribute("products", orderProductDTOList);
        //для админа все заказы
        req.getRequestDispatcher("/allOrders.jsp").forward(req, resp);


    }



    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

}
