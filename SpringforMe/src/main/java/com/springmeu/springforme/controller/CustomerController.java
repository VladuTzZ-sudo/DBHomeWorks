package com.springmeu.springforme.controller;

import com.springmeu.springforme.dao.customer.Customer;
import com.springmeu.springforme.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/view/customers/{id}")
    public ModelAndView viewById(@PathVariable(name = "id") int id) {
        Customer c = this.customerService.getById(id);

        ModelAndView modelAndView = new ModelAndView("customer");
        modelAndView.addObject("customer", c);

        return modelAndView;
    }

    /*@GetMapping("/view/customers")
//    @ResponseBody
    public ModelAndView viewAll() {
        List<Customer> personList = this.customerService.getAll();

        ModelAndView modelAndView = new ModelAndView("customer-list");
        modelAndView.addObject("customerList", personList);

        return modelAndView;
    }*/

    @GetMapping("/view/customers") ///customers?phone_pref=
    public ModelAndView filterCustomers(@RequestParam(name = "username", required = true, defaultValue = "") String username,
                                        @RequestParam(name = "city", required = true, defaultValue = "") String city,
                                        @RequestParam(name = "country", required = true, defaultValue = "") String country) {
        List<Customer> personList;

        personList = this.customerService.filterBy(username, city, country);

        ModelAndView modelAndView = new ModelAndView("customer-list");
        modelAndView.addObject("customerList", personList);

        return modelAndView;
    }
}
