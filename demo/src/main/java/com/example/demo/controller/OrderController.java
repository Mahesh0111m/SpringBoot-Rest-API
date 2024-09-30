package com.example.demo.controller;

import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping(path = "orders")
public class OrderController {

    @Autowired
    private OrderService orderservice;

    public OrderService getOrderservice() {
        return orderservice;
    }

    public void setOrderservice(OrderService orderservice) {
        this.orderservice = orderservice;
    }



    @PostMapping
    public @ResponseBody Order addOrder(@RequestBody Order order)
    {
        Order savedOrder = orderservice.addOrder(order);
        return savedOrder;
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Order getOrder( @PathVariable  Integer id)
    {
        return  orderservice.getOrder(id);
    }

    @PutMapping
    public @ResponseBody Order updateOrder(@RequestBody Order order)
    {
        return orderservice.updateOrder(order);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteOrder(@PathVariable Integer id)
    {
        return orderservice.deleteOrder(id);
    }
}
