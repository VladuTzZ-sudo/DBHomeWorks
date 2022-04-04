package com.springmeu.springforme.dao.orders.impl;

import com.springmeu.springforme.dao.orders.Order;
import com.springmeu.springforme.dao.orders.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Order> getAll() {
        String queryStr = "SELECT * FROM orders;";
        List<Order> ordersList = this.jdbcTemplate.query(queryStr, new OrderRowMapper());
        return ordersList;
    }

    @Override
    public Order getById(int id) {
        String queryStr = "SELECT * FROM orders WHERE id = " + id;
        Order c = this.jdbcTemplate.queryForObject(queryStr, new OrderRowMapper());
        return c;
    }

    @Override
    public boolean insert(Order p) {
        String sqlStr = "INSERT INTO orders (order_date, shipped_date, status, comments, customer_id) VALUES(?, ?, ?, ?, ?)";
        KeyHolder kh = new GeneratedKeyHolder();
        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, String.valueOf(p.getOrder_date()));
            ps.setString(2, String.valueOf(p.getShipped_date()));
            ps.setString(3, p.getStatus());
            ps.setString(4, p.getComments());
            ps.setString(5, String.valueOf(p.getId()));

            return ps;
        }, kh);

        // TO DO
        return kh.getKey() != null;
    }

    @Override
    public boolean updateById(int id, Order p) {
        String query = "UPDATE orders SET order_date = ?, shipped_date = ?, status = ?, comments = ?, customer_id = ? WHERE id = ?";
        int result = this.jdbcTemplate.update(query, p.getOrder_date(), p.getShipped_date(), p.getStatus(),
                p.getComments(), p.getCustomer_id(), p.getId());

        return result > 0;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "DELETE from oreders WHERE id = " + id;
        int result = this.jdbcTemplate.update(query);
        return result > 0;
    }
}
