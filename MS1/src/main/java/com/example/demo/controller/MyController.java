package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.servies.ProductServie;


@RestController
public class MyController {

    @Autowired
    private ProductServie service;

    // API 1: GET ALL PRODUCTS
    @GetMapping("/getAllProductsMS1")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    // API 2: GET PRODUCT BY ID
    @GetMapping("/getProductByIdMS1/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    // API 3: ADD PRODUCT
    @PostMapping("/addProductMS1")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    // API 4: DELETE PRODUCT
    @DeleteMapping("/deleteProductMS1/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    // API 5: UPDATE PRODUCT
    @PutMapping("/updateProductMS1/{id}")
    public Product updateProduct(
            @PathVariable int id,
            @RequestBody Product product) {

        return service.updateProduct(id, product);
    }
}