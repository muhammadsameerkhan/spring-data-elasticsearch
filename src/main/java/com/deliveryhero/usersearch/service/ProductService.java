package com.deliveryhero.usersearch.service;

import com.deliveryhero.usersearch.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);
}