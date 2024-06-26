package com.deliveryhero.usersearch.repository;

import com.deliveryhero.usersearch.entity.ProductDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductESRepository extends ElasticsearchRepository<ProductDocument, Long> {

}
