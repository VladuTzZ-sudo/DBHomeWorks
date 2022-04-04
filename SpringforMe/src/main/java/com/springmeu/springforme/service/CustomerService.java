package com.springmeu.springforme.service;

import com.springmeu.springforme.dao.customer.Customer;
import com.springmeu.springforme.dao.customer.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDAO customerDAO;

    public List<Customer> getAll() {
        return this.customerDAO.getAll();
    }

    public Customer getById(int id) {
        return this.customerDAO.getById(id);
    }

    public boolean insert(Customer c) {
        return this.customerDAO.insert(c);
    }

    public boolean updateById(int id, Customer c) {
        return this.customerDAO.updateById(id, c);
    }

    public boolean deleteById(int id) {
        return this.customerDAO.deleteById(id);
    }

    public List<Customer> filterBy(String username, String city, String country) {
        return this.customerDAO.filterBy(username, city, country);
    }
}
