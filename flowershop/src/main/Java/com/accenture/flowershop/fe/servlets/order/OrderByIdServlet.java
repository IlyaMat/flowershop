package com.accenture.flowershop.fe.servlets.order;

import com.accenture.flowershop.be.access.orderproduct.OrderProductDAO;
import com.accenture.flowershop.be.business.order.OrderBusinessService;
import com.accenture.flowershop.be.business.orderproduct.OrderProductBusinessService;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.orderproduct.OrderProduct;
import com.accenture.flowershop.fe.dto.order.OrderDTO;
import com.accenture.flowershop.fe.dto.orderproduct.OrderProductDTO;
import com.accenture.flowershop.fe.dto.product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/orders/order")
public class OrderByIdServlet extends HttpServlet {

    @Autowired
    private OrderBusinessService orderBusinessService;
   /* @Autowired
    private OrderProductBusinessService orderProductBusinessService;
    @Autowired
    private OrderProductDAO orderProductDAO;//переделать потом , выше*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //long orderId = Long.parseLong(req.getParameter("id"));
        int orderId = Integer.parseInt(req.getParameter("id"));

        Order order= orderBusinessService.findOrderById(orderId);
        List<OrderProduct> orderProducts = order.getOrderProducts();

        List<OrderProductDTO> orderProductDTOList = new ArrayList<>();

        for (OrderProduct orderProduct : orderProducts) {
            OrderProductDTO orderProductDTO = new OrderProductDTO();
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(orderProduct.getProduct().getName());
            productDTO.setId(orderProduct.getProduct().getId());
            orderProductDTO.setProduct(productDTO);
            orderProductDTO.setQuantity(orderProduct.getQuantity());

            orderProductDTOList.add(orderProductDTO);
        }
        req.setAttribute("orderProducts", orderProductDTOList);
        req.getRequestDispatcher("/order.jsp").forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
