package com.springmeu.springforme.dao.orders.impl;

import com.springmeu.springforme.dao.orders.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order c = new Order();
        c.setId(rs.getInt("id"));
        c.setComments(rs.getString("comments"));
        c.setOrder_date(rs.getDate("order_date"));
        c.setShipped_date(rs.getDate("shipped_date"));
        c.setStatus(rs.getString("status"));
        c.setCustomer_id(rs.getInt("customer_id"));

        return c;
    }
}
