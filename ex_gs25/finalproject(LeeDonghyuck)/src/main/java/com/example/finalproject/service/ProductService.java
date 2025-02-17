//package com.example.finalproject.service;
//
//import com.example.finalproject.models.entity.Product;
//import com.example.finalproject.repository.ProductRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProductService {
//
//    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    public List<Product> getAllProducts() {
//        List<Product> products = productRepository.findAll();
//        logger.info("Retrieved products: {}", products);
//        return products;
//    }
//
//    public Product addProduct(Product product) {
//        return productRepository.save(product);
//    }
//}
