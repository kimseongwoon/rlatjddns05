//package com.example.finalproject.repository;
//
//import com.example.finalproject.models.entity.DifferentiatedProduct;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface DifferentiatedProductRepository extends JpaRepository<DifferentiatedProduct, Long> {
//    // 이름으로 차별화된 상품을 찾는 커스텀 쿼리 메소드
//    Optional<DifferentiatedProduct> findByName(String name);
//
//    // 가격 범위로 차별화된 상품을 찾는 커스텀 쿼리 메소드
//    Optional<DifferentiatedProduct> findByPriceBetween(double minPrice, double maxPrice);
//}