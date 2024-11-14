package com.project.ecommerce.model.mapper;

import com.project.ecommerce.model.domain.Product;
import com.project.ecommerce.model.dto.ProductDto;

public class ProductMapper {

    public static ProductDto toDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }

    public static Product toBO(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getName(), productDto.getPrice());
    }
}
