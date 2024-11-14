package com.project.ecommerce.controller;

import com.project.ecommerce.model.dto.ProductDto;
import com.project.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    @Operation(summary = "Add a new product")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.addProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtain a product given its id")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long id) {
        return productService.getProductById(id)
                .map(pDto -> new ResponseEntity<>(pDto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    @Operation(summary = "Obtain all the products")
    public ResponseEntity<List<ProductDto>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit a product given its id and data")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long id, @Valid @RequestBody ProductDto productDto) {
        return productService.editProduct(id, productDto)
                .map(pDto -> new ResponseEntity<>(pDto, HttpStatus.ACCEPTED))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product given its id")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product " + id + " deleted successfully.");
    }
}
