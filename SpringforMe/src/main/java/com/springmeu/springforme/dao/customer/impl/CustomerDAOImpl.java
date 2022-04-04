package com.springmeu.springforme.dao.customer.impl;

import com.springmeu.springforme.dao.customer.Customer;
import com.springmeu.springforme.dao.customer.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getAll() {
        String queryStr = "SELECT * FROM customers;";
        List<Customer> customerList = this.jdbcTemplate.query(queryStr, new CustomerRowMapper());
        return customerList;
    }

    @Override
    public Customer getById(int id) {
        String queryStr = "SELECT * FROM customers WHERE id = " + id;
        return this.jdbcTemplate.queryForObject(queryStr, new CustomerRowMapper());
    }

    @Override
    public boolean insert(Customer p) {
        String sqlStr = "INSERT INTO customers (username, last_name, first_name, phone, address, city, postal_code, country) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        KeyHolder kh = new GeneratedKeyHolder();
        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getUsername());
            ps.setString(2, p.getLast_name());
            ps.setString(3, p.getFirst_name());
            ps.setString(4, p.getPhone());
            ps.setString(5, p.getAddress());
            ps.setString(6, p.getCity());
            ps.setString(7, p.getPostal_code());
            ps.setString(8, p.getCountry());
            return ps;
        }, kh);

        // TO DO
        return kh.getKey() != null;
    }

    @Override
    public boolean updateById(int id, Customer c) {
        String query = "UPDATE customers SET " +
                "username = ?, last_name = ?, first_name = ?, phone = ?, address = ?, city = ?, postal_code = ?, country =  WHERE id = ?";
        int result = this.jdbcTemplate.update(query, c.getUsername(), c.getLast_name(), c.getFirst_name(),
                c.getPhone(), c.getAddress(), c.getCity(), c.getPostal_code(), c.getCountry(), c.getId());

        return result > 0;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "DELETE from customers WHERE id = " + id;
        int result = this.jdbcTemplate.update(query);
        return result > 0;
    }

    @Override
    public List<Customer> filterBy(String username, String city, String country) {
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM customers");
        boolean ok = false;
        if (!username.equals("")) {
            stringBuilder.append(" WHERE ");
            stringBuilder.append("username = ").append("'").append(username).append("'");
            ok = true;
        }
        if (!city.equals("")) {
            if (!ok){
                stringBuilder.append(" WHERE ");
            }else{
                stringBuilder.append(" AND ");
            }
            stringBuilder.append("city = ").append("'").append(city).append("'");
            ok = true;
        }
        if (!country.equals("")) {
            if (!ok){
                stringBuilder.append(" WHERE ");
            }else{
                stringBuilder.append(" AND ");
            }
            stringBuilder.append("country = ").append("'").append(country).append("'");
        }

        String queryStr = stringBuilder.toString();
        return this.jdbcTemplate.query(queryStr, new CustomerRowMapper());
    }
}
