package com.project.ecommerce.service;

import com.project.ecommerce.model.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    ProductDto addProduct(ProductDto productDto);
    Optional<ProductDto> getProductById(Long id);
    List<ProductDto> getAll();
    Optional<ProductDto> editProduct(Long id, ProductDto productDto);
    void deleteProduct(Long id);
}
