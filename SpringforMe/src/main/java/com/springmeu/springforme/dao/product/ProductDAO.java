package com.springmeu.springforme.dao.product;

import java.util.List;

public interface ProductDAO {
    // CRUD
    List<Product> getAll();
    Product getById(int id);
    boolean insert(Product p);
    boolean updateById(int id, Product p);
    boolean deleteById(int id);
}
