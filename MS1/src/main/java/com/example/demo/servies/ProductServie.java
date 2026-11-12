package com.example.demo.servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductInterface;

@Service
public class ProductServie {

    @Autowired
    private ProductInterface repo;

    // 1. Get All Products
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // 2. Get Product By ID
    public Product getProductById(int id) {
        return repo.findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Product not found: " + id
                    )
                );
    }

    // 3. Add Product
    public Product addProduct(Product product) {

        if (repo.existsById(product.getPid())) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Product ID already exists"
            );
        }

        return repo.save(product);
    }

    // 4. Delete Product
    public String deleteProduct(int id) {

        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Product not found: " + id
            );
        }

        repo.deleteById(id);

        return "Product deleted successfully";
    }

    // 5. Update Product
    public Product updateProduct(int id, Product product) {

        Product existing = getProductById(id);

        existing.setPname(product.getPname());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());

        return repo.save(existing);
    }
}