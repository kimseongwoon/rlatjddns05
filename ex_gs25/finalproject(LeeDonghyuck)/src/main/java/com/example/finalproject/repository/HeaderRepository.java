//package com.example.finalproject.repository;
//
//import com.example.finalproject.models.entity.Header;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface HeaderRepository extends JpaRepository<Header, Long> {
//    // 헤더 이름으로 찾는 커스텀 쿼리 메소드
//    Optional<Header> findByName(String name);
//
//    // 헤더 설명에 키워드가 포함된 항목 찾기
//    Optional<Header> findByDescriptionContaining(String keyword);
//}