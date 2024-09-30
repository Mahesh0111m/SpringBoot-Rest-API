package com.example.demo.service;

import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repo.OrderRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderrepo;

    public OrderRepo getOrderrepo() {
        return orderrepo;
    }

    public void setOrderrepo(OrderRepo orderrepo) {
        this.orderrepo = orderrepo;
    }

    public Order addOrder(Order order) {
       Order savedOrder = orderrepo.save(order);
       return  savedOrder;
    }

    public Order getOrder(Integer id)
    {
        return orderrepo.findById(id).orElse(null);

    }

    public Order updateOrder(Order order)
    {
        Order orderFromDb = orderrepo.findById(order.getId()).orElse(null);
        if(orderFromDb == null)
        {
            throw new RuntimeException("No such order exist");
        }

        orderFromDb.setCustomerName(order.getCustomerName());
        orderFromDb.setAmount(order.getAmount());

        return orderrepo.save(orderFromDb);
    }


    public String deleteOrder(Integer id)
    {
        orderrepo.deleteById(id);
        return "deleted";
    }
}
