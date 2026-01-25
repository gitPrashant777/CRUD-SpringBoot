package com.crud.CRUD.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.crud.CRUD.Model.ProductModel;
import com.crud.CRUD.Services.ProductServices;

@RestController
public class Product {

    private final ProductServices services;

    public Product(ProductServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public String welcome() {
        return "Hello Prashant Kumar";
    }

    @GetMapping("/products")
    public List<ProductModel> getAllProducts() {
        return services.showProducts();
    }

    @GetMapping("/products/{id}")
    public ProductModel getProductById(@PathVariable int id) {
        return services.productById(id);
    }
    
    @PutMapping("/products")
    public void update(@RequestBody ProductModel product) {
        services.updateproduct(product);
    }
    @DeleteMapping("/products")
    public void delete(@RequestBody ProductModel product) {
        services.deleteproduct(product);
    }

}
