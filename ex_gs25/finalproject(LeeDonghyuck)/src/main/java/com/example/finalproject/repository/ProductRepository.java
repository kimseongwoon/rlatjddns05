//package com.example.finalproject.repository;
//
//import com.example.finalproject.models.entity.Product;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface ProductRepository extends JpaRepository<Product, Long> {
//    // 이름으로 상품을 찾는 커스텀 쿼리 메소드
//    Optional<Product> findByName(String name);
//
//    // 가격 범위로 상품을 찾는 커스텀 쿼리 메소드
//    Optional<Product> findByPriceBetween(double minPrice, double maxPrice);
//}