package com.example.springbootfrontendbackend.service;

import com.example.springbootfrontendbackend.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {


    Product addProduct(Product product);

    List<Product> getAllProducts();
}
