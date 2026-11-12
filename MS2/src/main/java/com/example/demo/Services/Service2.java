package com.example.demo.Services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Product;

@Service
public class Service2 {

    @Autowired
    private RestTemplate restTemplate;

    // MS1 Base URL
    private final String MS1_URL = "http://localhost:9999";

    // 1. GET ALL PRODUCTS
    public List<Product> getAllProducts() {

        Product[] products = restTemplate.getForObject( MS1_URL + "/getAllProductsMS1",Product[].class);

        return Arrays.asList(products);
    }

    // 2. GET PRODUCT BY ID
    public Product getProductById(int id) {

        return restTemplate.getForObject(MS1_URL + "/getProductByIdMS1/" + id, Product.class);
    }

    // 3. ADD PRODUCT
    public Product addProduct(Product product) {

        return restTemplate.postForObject( MS1_URL + "/addProductMS1",product,Product.class);
    }

    // 4. DELETE PRODUCT
    public String deleteProduct(int id) {

        restTemplate.delete(
            MS1_URL + "/deleteProductMS1/" + id
        );

        return "Product deleted successfully";
    }

    // 5. UPDATE PRODUCT
    public Product updateProduct(int id, Product product) {

        restTemplate.put(
            MS1_URL + "/updateProduct/" + id,
            product
        );

        return getProductById(id);
    }
}