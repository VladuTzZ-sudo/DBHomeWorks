package com.springmeu.springforme.dao.product.impl;

import com.springmeu.springforme.dao.orders.Order;
import com.springmeu.springforme.dao.product.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product c = new Product();
        c.setId(rs.getInt("id"));
        c.setCode(rs.getString("code"));
        c.setName(rs.getString("name"));
        c.setDescription(rs.getString("description"));
        c.setStock(rs.getInt("stock"));
        c.setPrice(rs.getDouble("price"));

        return c;
    }
}
