package com.deliveryhero.usersearch.controller;

import com.deliveryhero.usersearch.entity.Product;
import com.deliveryhero.usersearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.deliveryhero.usersearch.entity.ProductDocument;
import com.deliveryhero.usersearch.service.ProductSearchService;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductSearchService productSearchService;

    @Autowired
    public ProductController(ProductService productService, ProductSearchService productSearchService) {
        this.productService = productService;
        this.productSearchService = productSearchService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    @GetMapping("/search")
    public List<ProductDocument> searchProducts(@RequestParam String keyword) {
        return productSearchService.searchProducts(keyword);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}