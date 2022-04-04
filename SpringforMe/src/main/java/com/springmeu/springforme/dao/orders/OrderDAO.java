package com.springmeu.springforme.dao.orders;

import java.util.List;

public interface OrderDAO {
    // CRUD
    List<Order> getAll();
    Order getById(int id);
    boolean insert(Order p);
    boolean updateById(int id, Order p);
    boolean deleteById(int id);
}
