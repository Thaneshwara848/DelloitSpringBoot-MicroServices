package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.Services.Service2;

@RestController
public class MyController2 {

    @Autowired
    private Service2 service;

    // 1. GET ALL PRODUCTS
    @GetMapping("/getProductMS2")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    // 2. GET PRODUCT BY ID
    @GetMapping("/getProductMS2/{id}")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    // 3. ADD PRODUCT
    @PostMapping("/setProdMS2")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    // 4. DELETE PRODUCT
    @DeleteMapping("/deleteProdMS2/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    // 5. UPDATE PRODUCT
    @PutMapping("/updateProdMS2/{id}")
    public Product updateProduct(
            @PathVariable int id,
            @RequestBody Product product) {

        return service.updateProduct(id, product);
    }
}