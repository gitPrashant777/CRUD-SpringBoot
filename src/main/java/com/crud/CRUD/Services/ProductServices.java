package com.crud.CRUD.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.CRUD.Model.ProductModel;
import com.crud.CRUD.Repository.ProductRepo;

@Service
public class ProductServices {

    @Autowired
    private ProductRepo repo;

    // GET all products
    public List<ProductModel> showProducts() {
        return repo.findAll();
    }

    // POST product
    public ProductModel addProduct(ProductModel product) {
        return repo.save(product);
    }

    // GET by id
    public ProductModel productById(int id) {
        return repo.findById(id).orElse(null);
    }

    // PUT update
    public ProductModel updateProduct(ProductModel product) {
        return repo.save(product);
    }

    // DELETE by id
    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}
