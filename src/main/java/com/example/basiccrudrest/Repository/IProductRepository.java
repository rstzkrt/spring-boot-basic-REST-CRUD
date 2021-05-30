package com.example.basiccrudrest.Repository;

import com.example.basiccrudrest.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);
}