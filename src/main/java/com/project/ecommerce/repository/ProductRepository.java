package com.project.ecommerce.repository;

import com.project.ecommerce.model.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
