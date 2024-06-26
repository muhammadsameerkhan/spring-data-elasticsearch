package com.deliveryhero.usersearch.service.impl;

import com.deliveryhero.usersearch.entity.Product;
import com.deliveryhero.usersearch.entity.ProductDocument;
import com.deliveryhero.usersearch.repository.ProductESRepository;
import com.deliveryhero.usersearch.service.ProductIndexService;
import com.deliveryhero.usersearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Logger;


@Service
public class ProductIndexServiceImpl implements ProductIndexService {

    private static final Logger logger = Logger.getLogger(ProductIndexServiceImpl.class.getName());

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductESRepository productESRepository;

    @PostConstruct
    @Override
    public void indexExistingData() {
        try {
            List<Product> products = productService.getAllProducts();
            logger.info("Fetched products from PostgreSQL: " + products.size());

            List<ProductDocument> productDocuments = products.stream()
                    .map(this::mapToProductDocument)
                    .collect(Collectors.toList());

            productESRepository.saveAll(productDocuments);
            logger.info("Indexed products to Elasticsearch: " + productDocuments.size());
        } catch (Exception e) {
            logger.severe("Error indexing data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private ProductDocument mapToProductDocument(Product product) {
        ProductDocument productDocument = new ProductDocument();
        productDocument.setId(product.getId());
        productDocument.setName(product.getName());
        productDocument.setDescription(product.getDescription());
        productDocument.setTaste(product.getTaste());
        productDocument.setPrice(product.getPrice());
        productDocument.setIsDiscounted(product.getIsDiscounted());
        productDocument.setIsTrending(product.getIsTrending());
        productDocument.setCategory(product.getCategory());
//        productDocument.setCreatedAt(product.getCreatedAt());
//        productDocument.setUpdatedAt(product.getUpdatedAt());
        productDocument.setRating(product.getRating());
        productDocument.setReviews(product.getReviews());
        productDocument.setAvailability(product.getAvailability());
        return productDocument;
    }
}