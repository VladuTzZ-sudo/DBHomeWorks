package com.springmeu.springforme.service;

import com.springmeu.springforme.dao.orders.Order;
import com.springmeu.springforme.dao.orders.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    OrderDAO OrderDAO;

    public List<Order> getAll() {
        return this.OrderDAO.getAll();
    }

    public Order getById(int id) {
        return this.OrderDAO.getById(id);
    }

    public boolean insert(Order c) {
        return this.OrderDAO.insert(c);
    }

    public boolean updateById(int id, Order c) {
        return this.OrderDAO.updateById(id, c);
    }

    public boolean deleteById(int id) {
        return this.OrderDAO.deleteById(id);
    }
}
