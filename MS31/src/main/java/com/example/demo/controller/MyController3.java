package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.Services.Service3;

@RestController
public class MyController3 {

    @Autowired
    private Service3 service;

    // 1. GET ALL PRODUCTS
    @GetMapping("/getProductMS3")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    // 2. GET PRODUCT BY ID
    @GetMapping("/getProductMS3/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    // 3. ADD PRODUCT
    @PostMapping("/setProdMS3")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    // 4. DELETE PRODUCT
    @DeleteMapping("/deleteProdMS3/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    // 5. UPDATE PRODUCT
    @PutMapping("/updateProdMS3/{id}")
    public Product updateProduct(
            @PathVariable int id,
            @RequestBody Product product) {

        return service.updateProduct(id, product);
    }
}