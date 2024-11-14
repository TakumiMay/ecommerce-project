package com.project.ecommerce.service;

import com.project.ecommerce.model.domain.Product;
import com.project.ecommerce.model.dto.ProductDto;
import com.project.ecommerce.model.mapper.ProductMapper;
import com.project.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = ProductMapper.toBO(productDto);
        return ProductMapper.toDto(productRepository.save(product));
    }

    @Override
    public Optional<ProductDto> getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent())
            return optionalProduct.map(ProductMapper::toDto);
        return Optional.empty();
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDto> editProduct(Long id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            productDto.setId(id);
            return Optional.of(ProductMapper.toDto(
                    productRepository.save(ProductMapper.toBO(productDto))));
        }
        return Optional.empty();
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.findById(id)
                .ifPresentOrElse(
                        product -> productRepository.deleteById(id),
                        () -> { throw new RuntimeException("The product to delete by id does not exist"); }
                );
    }
}
