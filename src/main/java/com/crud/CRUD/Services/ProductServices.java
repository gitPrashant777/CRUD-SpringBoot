package com.crud.CRUD.Services;

import java.util.*;
import org.springframework.stereotype.Service;
import com.crud.CRUD.Model.ProductModel;

@Service
public class ProductServices {

    private List<ProductModel> products = new ArrayList<>(
        Arrays.asList(
            new ProductModel(1, "Smartphone", 70000, 50, "Redmi"),
            new ProductModel(100, "Smartphone", 70000, 50, "Redmi"),
            new ProductModel(101, "4G PHONE", 10000, 50, "Apple"),
            new ProductModel(102, "5G PHONE", 17000, 50, "Samsung"),
            new ProductModel(103, "3G PHONE", 27000, 50, "HTCL")
        )
    );

    public List<ProductModel> showProducts() {
        return products;
    }

    public ProductModel productById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

	public void updateproduct(ProductModel pro) {
		 for (int i = 0; i < products.size(); i++) {
		        if (products.get(i).getId() == pro.getId()) {
		            products.set(i, pro);
		            return;
		        }
		 }
	}
	public void deleteproduct(ProductModel pro) {
		 for (int i = 0; i < products.size(); i++) {
		        if (products.get(i).getId() == pro.getId()) {
		            products.remove(i);
		            return;
		        }
		 }
	}
}
