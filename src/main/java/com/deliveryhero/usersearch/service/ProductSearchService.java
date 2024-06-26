package com.deliveryhero.usersearch.service;

import com.deliveryhero.usersearch.entity.ProductDocument;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductSearchService {

    List<ProductDocument> searchProducts(String keyword);
}