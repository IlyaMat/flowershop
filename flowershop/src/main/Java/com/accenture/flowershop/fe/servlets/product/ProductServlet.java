/*
package com.accenture.flowershop.fe.servlets.product;

import com.accenture.flowershop.be.business.product.ProductBusinessService;
import com.accenture.flowershop.be.entity.product.Product;
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

//@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    @Autowired
    private ProductBusinessService productBusinessService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productBusinessService.getAllProducts();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            productDTOS.add(productDTO);
        }
        req.setAttribute("products", productDTOS);
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
       // req.getRequestDispatcher("/cart.jsp").forward(req,resp);


    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
*/
