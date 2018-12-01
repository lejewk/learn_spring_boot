package com.devwook88.learn_spring_boot.service;

import com.devwook88.learn_spring_boot.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryProductService {
    public List<Product> getProducts() {
        Product prod1 = new Product("gray", "t-shirt", 5000);
        Product prod2 = new Product("red", "apple", 190);
        Product prod3 = new Product("yellow", "banana", 500);
        Product prod4 = new Product("white", "jam", 1000);

        ArrayList<Product> products = new ArrayList();
        products.add(prod1);
        products.add(prod2);
        products.add(prod3);
        products.add(prod4);

        return products;
    }
}
