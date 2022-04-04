package com.springmeu.springforme.controller;

import com.springmeu.springforme.dao.product.Product;
import com.springmeu.springforme.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/view/products/{id}")
    public ModelAndView viewById(@PathVariable(name = "id") int id) {
        Product c = this.productService.getById(id);

        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("product", c);

        return modelAndView;
    }

    @GetMapping("/view/products")
//    @ResponseBody
    public ModelAndView viewAll() {
        List<Product> personList = this.productService.getAll();

        ModelAndView modelAndView = new ModelAndView("product-list");
        modelAndView.addObject("products", personList);

        return modelAndView;
    }
}
