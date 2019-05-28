package com.accenture.flowershop.be.business.rest;

import com.accenture.flowershop.be.business.product.ProductBusinessServiceImpl;
import com.accenture.flowershop.be.entity.product.Product;
import com.accenture.flowershop.fe.dto.cart.Cart;
import com.accenture.flowershop.fe.dto.cart.FlowerItem;
import com.accenture.flowershop.fe.dto.product.ProductDTO;
import com.accenture.flowershop.fe.dto.user.UserDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.StringReader;

@Component
@Path("/shoppingcart")
public class CartRest {

    @Autowired
    private ProductBusinessServiceImpl productBusinessService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public void putToCart(String json, @Context HttpServletRequest req) {
        HttpSession session = req.getSession();

        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(new StringReader(json));
        JsonObject jsonObject = jsonTree.getAsJsonObject();
        int productId = jsonObject.get("productId").getAsInt();
        //int quantity = jsonObject.get("quantity").getAsInt();


        //System.out.println("quantity = " + quantity);

        Cart cart = (Cart) ((UserDTO) session.getAttribute("user")).getCustomer().getCart();
        Product product = productBusinessService.findProductById(productId);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());


        //FlowerItem flowerItem = new FlowerItem(productDTO);
        cart.addToCart(productDTO);

    }
}
