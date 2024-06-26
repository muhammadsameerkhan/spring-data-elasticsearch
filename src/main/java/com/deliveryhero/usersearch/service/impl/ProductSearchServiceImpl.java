package com.deliveryhero.usersearch.service.impl;

import com.deliveryhero.usersearch.entity.ProductDocument;
import com.deliveryhero.usersearch.service.ProductSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class ProductSearchServiceImpl implements ProductSearchService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<ProductDocument> searchProducts(String keyword) {

//        MultiMatchQueryBuilder multiMatchQuery = QueryBuilders.multiMatchQuery(keyword)
//                .field("name")
//                .field("description")
//                .field("category");
    //
//        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
//                .must(multiMatchQuery);

        var searchQuery = NativeQuery.builder().withQuery(builder -> builder.multiMatch(
                        builder1 -> builder1.query(keyword).fields("name", "description", "category", "taste"))
                )
//                .withPageable(PageRequest.of(page, size))
                .build();

        SearchHits<ProductDocument> searchHits = elasticsearchTemplate.search(searchQuery, ProductDocument.class);
        return searchHits.getSearchHits().stream()
                .map(hit -> hit.getContent())
                .collect(Collectors.toList());
    }
}