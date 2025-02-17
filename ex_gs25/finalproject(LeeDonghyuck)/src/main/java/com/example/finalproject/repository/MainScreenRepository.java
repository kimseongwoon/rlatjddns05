//package com.example.finalproject.repository;
//
//import com.example.finalproject.models.entity.MainScreen;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface MainScreenRepository extends JpaRepository<MainScreen, Long> {
//    // 메인 화면의 제목으로 찾는 커스텀 쿼리 메소드
//    Optional<MainScreen> findByTitle(String title);
//
//    // 설명 내용으로 메인 화면 찾기
//    Optional<MainScreen> findByDescriptionContaining(String keyword);
//}
