package com.accenture.flowershop.be.business.order;

import com.accenture.flowershop.be.access.order.OrderDAO;
import com.accenture.flowershop.be.business.customer.CustomerBusinessService;
import com.accenture.flowershop.be.business.stock.StockBusinessService;
import com.accenture.flowershop.be.entity.customer.Customer;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.orderproduct.OrderProduct;
import com.accenture.flowershop.be.entity.product.Product;
import com.accenture.flowershop.fe.dto.cart.FlowerItem;
import com.accenture.flowershop.fe.dto.order.OrderDTO;
import com.accenture.flowershop.fe.dto.product.ProductDTO;
import com.accenture.flowershop.fe.enums.Order.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderBusinessServiceImpl implements OrderBusinessService {

    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private CustomerBusinessService customerBusinessService;
    @Autowired
    private StockBusinessService stockBusinessService;

    @Override
    @Transactional
    public void createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        Customer customer = customerBusinessService.findCustomerById(orderDTO.getCustomer().getId());
        order.setCustomer(customer);
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setCreatedAt(orderDTO.getCreatedAt());
        order.setStatus(orderDTO.getStatus());//CREATED

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (FlowerItem item : orderDTO.getCustomer().getCart().getBasketGoods().values()) {
            ProductDTO productDTO = item.getProduct();

            Product product = new Product();
            product.setId(productDTO.getId());
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            //OrderProduct
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setProduct(product);
            orderProduct.setOrder(order);
            orderProduct.setQuantity(item.getQuantityFlower()); //кол-во этого цветка
            orderProducts.add(orderProduct);

            /*System.out.println("createdAt: " + order.getCreatedAt() +
                    " fullnameCustomer: " + order.getCustomer().getFullname());
            System.out.println("totalPrice: " +order.getTotalPrice());*/
        }
        order.setOrderProducts(orderProducts);
        addOrder(order); //сохраним
    }

    @Override
    @Transactional
    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

    @Override
    @Transactional
    public Order payOrder(long orderId) {
        Order order = orderDAO.findOrderById(orderId);
        Customer customer = order.getCustomer();
        customer.setBalance(customer.getBalance().subtract(order.getTotalPrice()));
        order.setStatus(OrderStatus.ОПЛАЧЕН);
        addOrder(order);
        //+изменим кол-во продуктов в наличии
        List<OrderProduct> orderProducts = order.getOrderProducts();
        for (OrderProduct orderProduct : orderProducts) {
            stockBusinessService.changeQuantityProduct(orderProduct.getProduct(),orderProduct.getQuantity() );
        }
        return order;

    }

    @Override
    @Transactional
    public Order closeOrder(long orderId) {
        Order order = orderDAO.findOrderById(orderId);
        order.setStatus(OrderStatus.ЗАКРЫТ);
        order.setClosedAt(new Date());
        addOrder(order);
        return order;
    }

    @Override
    public Order findOrderById(long id) {
        return orderDAO.findOrderById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orderList = orderDAO.getAllOrders();
        return orderList;
    }

    @Override
    public List<Order> findOrderByCustomer(Customer customer) {
        return orderDAO.findOrderByCustomer(customer);
    }
}
