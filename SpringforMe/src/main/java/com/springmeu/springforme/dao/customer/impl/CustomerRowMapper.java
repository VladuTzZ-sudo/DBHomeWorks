package com.springmeu.springforme.dao.customer.impl;

import com.springmeu.springforme.dao.customer.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer c = new Customer();
        c.setId(rs.getInt("id"));
        c.setUsername(rs.getString("username"));
        c.setLast_name(rs.getString("last_name"));
        c.setFirst_name(rs.getString("first_name"));
        c.setPhone(rs.getString("phone"));
        c.setAddress(rs.getString("address"));
        c.setPostal_code(rs.getString("postal_code"));
        c.setCountry(rs.getString("country"));
        c.setCity(rs.getString("city"));

        return c;
    }
}