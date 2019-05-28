package com.accenture.flowershop.fe.servlets.product;

import com.accenture.flowershop.be.business.product.ProductBusinessService;
import com.accenture.flowershop.be.entity.product.Product;
import com.accenture.flowershop.be.entity.stock.Stock;
import com.accenture.flowershop.fe.dto.product.ProductDTO;
import com.accenture.flowershop.fe.dto.stock.StockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/products")
public class SearchProductServlet extends HttpServlet {
    @Autowired
    private ProductBusinessService productBusinessService;

    //переписать по норм
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        BigDecimal minPrice = null;
        BigDecimal maxPrice = null;

        List<Product> products = productBusinessService.getAllProducts();
        List<ProductDTO> productDTOS = new ArrayList<>();

        String name = req.getParameter("name");
        String min = req.getParameter("minPrice");
        String max = req.getParameter("maxPrice");
        if (min != null && !min.isEmpty() && max != null && !max.isEmpty()) {
            minPrice = new BigDecimal(min);
            maxPrice = new BigDecimal(max);
            //System.out.println("biDecimal Min: " + minPrice);
        }

        for (Product product : products) {
            //stock
            /*Stock stock = product.getStock();
            StockDTO stockDTO = new StockDTO();
            stockDTO.setQuantity(stock.getQuantity());*/

            if (name != null & minPrice == null && maxPrice == null) {
                String encName = new String(name.getBytes("ISO-8859-1"), "utf-8");//по русски
                // if (maxPrice != null & minPrice != null) {
                if (product.getName().contains(encName)) {
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setId(product.getId());
                    productDTO.setName(product.getName());
                    productDTO.setPrice(product.getPrice());
                    //stock
                    //stockDTO.setProductDTO(productDTO);
                    //
                   // productDTO.setStock(stockDTO);
                    productDTOS.add(productDTO);
                }
            } else if (minPrice != null && maxPrice != null) {
                if (product.getPrice().compareTo(minPrice) == 1 &&
                        product.getPrice().compareTo(maxPrice) == -1) {
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setId(product.getId());
                    productDTO.setName(product.getName());
                    productDTO.setPrice(product.getPrice());
                    //stock
                   // stockDTO.setProductDTO(productDTO);
                    //
                   // productDTO.setStock(stockDTO);
                    productDTOS.add(productDTO);
                }
            } else {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setId(product.getId());
                productDTO.setName(product.getName());
                productDTO.setPrice(product.getPrice());
                //stock
               // Stock stock = product.getStock();
               // StockDTO stockDTO = new StockDTO();
               // stockDTO.setId(product.getStock().getId());
               // stockDTO.setQuantity(product.getStock().getQuantity());
               // stockDTO.setProductDTO(productDTO);
                //
               // productDTO.setStock(stockDTO);
                productDTOS.add(productDTO);
            }
        }
        Collections.sort(productDTOS);
        req.setAttribute("products", productDTOS);
        req.getRequestDispatcher("/main.jsp").forward(req, resp);

    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

    }
}
