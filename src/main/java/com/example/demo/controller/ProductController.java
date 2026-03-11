package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {

        List<Product> products = productRepository.findByCategory(category);

        return ResponseEntity.ok(products);
    }
   @GetMapping("/price/{price}")
public ResponseEntity<List<Product>> getProductsByPrice(@PathVariable double price) {

    List<Product> products = productRepository.findByPriceGreaterThan(price);

    return ResponseEntity.ok(products);
}

@GetMapping("/rating/{rating}")
public ResponseEntity<List<Product>> getProductsByRating(@PathVariable double rating) {

    List<Product> products = productRepository.findByRatingGreaterThan(rating);

    return ResponseEntity.ok(products);
}
@PostMapping
public ResponseEntity<Product> createProduct(@RequestBody Product product) {

    Product savedProduct = productRepository.save(product);

    return ResponseEntity.ok(savedProduct);
}
@GetMapping
public ResponseEntity<Page<Product>> getProducts(
        @RequestParam int page,
        @RequestParam int size) {

    Pageable pageable = PageRequest.of(page, size);

    Page<Product> products = productRepository.findAll(pageable);

    return ResponseEntity.ok(products);
}

@GetMapping("/sorted")
public ResponseEntity<Page<Product>> getProductsSorted(
        @RequestParam int page,
        @RequestParam int size,
        @RequestParam String sortBy,
        @RequestParam Direction direction) {

    Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));

    Page<Product> products = productRepository.findAll(pageable);

    return ResponseEntity.ok(products);



}
}