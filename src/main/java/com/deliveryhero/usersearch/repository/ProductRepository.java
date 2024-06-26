package com.deliveryhero.usersearch.repository;

import com.deliveryhero.usersearch.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
