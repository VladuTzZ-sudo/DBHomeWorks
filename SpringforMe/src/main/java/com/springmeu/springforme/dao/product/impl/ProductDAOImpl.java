package com.springmeu.springforme.dao.product.impl;

import com.springmeu.springforme.dao.customer.Customer;
import com.springmeu.springforme.dao.customer.impl.CustomerRowMapper;
import com.springmeu.springforme.dao.orders.Order;
import com.springmeu.springforme.dao.orders.impl.OrderRowMapper;
import com.springmeu.springforme.dao.product.Product;
import com.springmeu.springforme.dao.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAll() {
        String queryStr = "SELECT * FROM products;";
        List<Product> productsList = this.jdbcTemplate.query(queryStr, new ProductRowMapper());
        return productsList;
    }

    @Override
    public Product getById(int id) {
        String queryStr = "SELECT * FROM products WHERE id = " + id;
        Product p = this.jdbcTemplate.queryForObject(queryStr, new ProductRowMapper());
        return p;
    }

    @Override
    public boolean insert(Product p) {
        String sqlStr = "INSERT INTO products (id, code, name, description, price) VALUES(?, ?, ?, ?, ?)";
        KeyHolder kh = new GeneratedKeyHolder();
        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, String.valueOf(p.getId()));
            ps.setString(2, p.getCode());
            ps.setString(3, p.getName());
            ps.setString(4, p.getDescription());
            ps.setString(5, String.valueOf(p.getPrice()));
            return ps;
        }, kh);

        // TO DO
        return kh.getKey() != null;
    }

    @Override
    public boolean updateById(int id, Product p) {
        String query = "UPDATE products SET " +
                "code = ?, name = ?, description = ?, price = ? =  WHERE id = ?";
        int result = this.jdbcTemplate.update(query, p.getCode(), p.getName(), p.getDescription(),
                p.getPrice(), p.getId());

        return result > 0;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "DELETE from products WHERE id = " + id;
        int result = this.jdbcTemplate.update(query);
        return result > 0;
    }
}
