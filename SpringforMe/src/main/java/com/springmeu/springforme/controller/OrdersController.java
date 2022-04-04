package com.springmeu.springforme.controller;

import com.springmeu.springforme.dao.orders.Order;
import com.springmeu.springforme.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @GetMapping("/view/orders/{id}")
    public ModelAndView viewById(@PathVariable(name = "id") int id) {
        Order c = this.ordersService.getById(id);

        ModelAndView modelAndView = new ModelAndView("order");
        modelAndView.addObject("order", c);

        return modelAndView;
    }

    @GetMapping("/view/orders")
//    @ResponseBody
    public ModelAndView viewAll() {
        List<Order> personList = this.ordersService.getAll();

        ModelAndView modelAndView = new ModelAndView("order-list");
        modelAndView.addObject("orderList", personList);

        return modelAndView;
    }
}
