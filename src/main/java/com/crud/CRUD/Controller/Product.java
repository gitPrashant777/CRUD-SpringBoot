package com.crud.CRUD.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.crud.CRUD.Model.ProductModel;
import com.crud.CRUD.Services.ProductServices;

@RestController
@RequestMapping("/products")
public class Product {

    private final ProductServices services;

    public Product(ProductServices services) {
        this.services = services;
    }

    @GetMapping("/")
    public String welcome() {
        return "Hello Prashant Kumar";
    }

    // POST - add product
    @PostMapping
    public ProductModel addProduct(@RequestBody ProductModel product) {
        return services.addProduct(product);
    }

    // GET - all products
    @GetMapping
    public List<ProductModel> getAllProducts() {
        return services.showProducts();
    }

    // GET - product by id
    @GetMapping("/{id}")
    public ProductModel getProductById(@PathVariable int id) {
        return services.productById(id);
    }

    // PUT - update product
    @PutMapping
    public ProductModel update(@RequestBody ProductModel product) {
        return services.updateProduct(product);
    }

    // DELETE - delete by id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        services.deleteProduct(id);
    }
}
