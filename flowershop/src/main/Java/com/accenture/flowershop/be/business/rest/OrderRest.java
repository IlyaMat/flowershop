package com.accenture.flowershop.be.business.rest;

import com.accenture.flowershop.be.business.order.OrderBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Component
@Path("/orders")
public class OrderRest {

    @Autowired
    private OrderBusinessService orderBusinessService;

    @POST
    @Path("close/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void closeOrder(@PathParam("id") long orderId, @Context HttpServletResponse resp) {
         orderBusinessService.closeOrder(orderId);
        try {
            resp.sendRedirect("/orders");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
