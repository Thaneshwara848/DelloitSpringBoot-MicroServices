package com.example.demo.Services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.Product;

@Service
public class Service3 {

    private final WebClient webClient;

    public Service3(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("http://localhost:9999")
                .build();
    }

    // 1. GET ALL PRODUCTS
    public List<Product> getAllProducts() {

        return webClient.get()
                .uri("/getAllProductsMS1")
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList()
                .block();
    }

    // 2. GET PRODUCT BY ID
    public Product getProductById(int id) {

        return webClient.get()
                .uri("/getProductByIdMS1/{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }

    // 3. ADD PRODUCT
    public Product addProduct(Product product) {

        return webClient.post()
                .uri("/addProductMS1")
                .bodyValue(product)
                .retrieve()
                .toBodilessEntity()
                .thenReturn(product)
                .block();
    }

    // 4. DELETE PRODUCT
    public String deleteProduct(int id) {

        webClient.delete()
                .uri("/deleteProductMS1/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();

        return "Product deleted successfully";
    }

    // 5. UPDATE PRODUCT
    public Product updateProduct(int id, Product product) {

        webClient.put()
                .uri("/updateProductMS1/{id}", id)
                .bodyValue(product)
                .retrieve()
                .toBodilessEntity()
                .block();

        // Read updated product from MS1
        return getProductById(id);
    }
}