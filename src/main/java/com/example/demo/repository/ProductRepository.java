package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product>findByCategory(String category);
   List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByRatingGreaterThan(Double rating);
      // JPQL
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findExpensiveProducts(double price);

    // JPQL multiple conditions
    @Query("SELECT p FROM Product p WHERE p.price > :price AND p.rating > :rating")
    List<Product> findTopProducts(double price, double rating);

    // Native SQL
    @Query(value = "SELECT * FROM products WHERE category = :category", nativeQuery = true)
    List<Product> findByCategoryNative(String category);
    
    
}
