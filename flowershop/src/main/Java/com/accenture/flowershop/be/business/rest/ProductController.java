package com.accenture.flowershop.be.business.rest;

import com.accenture.flowershop.be.business.product.ProductBusinessService;
import com.accenture.flowershop.be.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Controller
@EnableWebMvc //без этого будет ошибка 406
@RequestMapping("/flowers")
public class ProductController {

    @Autowired
    private ProductBusinessService productBusinessService;


    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public List<Product> getAllProducts() {
        List<Product> products = productBusinessService.getAllProducts();
        return products;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON,
            consumes = MediaType.APPLICATION_JSON)
    @ResponseBody
    public Product getProductById(@PathVariable("id") int id) {
        Product product = productBusinessService.findProductById(id);
        return product;

    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON,
            consumes = MediaType.APPLICATION_JSON)
    @ResponseBody
    public Product putProduct(@RequestBody Product product) {
        productBusinessService.addProduct(product);
        return product;
        //System.out.println("id: " + product.getId() + " name: " + product.getName() + " price: " + product.getPrice());
    }


    @RequestMapping(value = "/name", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public String print(@RequestBody String name) {
        //System.out.println(name);
        return name + " from print";//отвечает в body
    }



/* @Path("/movie")
    @Consumes("application/json")
    @Produces("application/json")
    public class MovieController {
        @GET
        @Path("/find") // пример URL http://localhost:8080/<appcontext>/movie/find?name=Love&year=2014
        public List<MovieViewDto> register(@QueryParam("name") String name, @QueryParam("year") int year) {
        }
        @GET
        @Path("/{id}") // пример URL http://localhost:8080/<appcontext>/movie/c4j938c1148
        public MovieDto getById(@PathParam("id") String id) {
        }
    }*/

}
