package com.springmeu.springforme.service;

import com.springmeu.springforme.dao.product.Product;
import com.springmeu.springforme.dao.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDAO ProductDAO;

    public List<Product> getAll() {
        return this.ProductDAO.getAll();
    }

    public Product getById(int id) {
        return this.ProductDAO.getById(id);
    }

    public boolean insert(Product c) {
        return this.ProductDAO.insert(c);
    }

    public boolean updateById(int id, Product c) {
        return this.ProductDAO.updateById(id, c);
    }

    public boolean deleteById(int id) {
        return this.ProductDAO.deleteById(id);
    }
}
