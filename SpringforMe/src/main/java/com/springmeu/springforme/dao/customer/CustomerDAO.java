package com.springmeu.springforme.dao.customer;

import java.util.List;

public interface CustomerDAO {
    // CRUD
    List<Customer> getAll();
    Customer getById(int id);
    boolean insert(Customer p);
    boolean updateById(int id, Customer p);
    boolean deleteById(int id);
    List<Customer> filterBy(String username, String city, String country);
}
