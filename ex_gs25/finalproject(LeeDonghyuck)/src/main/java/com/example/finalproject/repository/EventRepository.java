//package com.example.finalproject.repository;
//
//import com.example.finalproject.models.entity.Event;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//import java.util.Optional;
//
//@Repository
//public interface EventRepository extends JpaRepository<Event, Long> {
//    // 이름으로 행사를 찾는 커스텀 쿼리 메소드
//    Optional<Event> findByName(String name);
//
//    // 특정 날짜 사이에 있는 행사들을 찾는 커스텀 쿼리 메소드
//    Optional<Event> findByStartDateBetweenAndEndDateBetween(LocalDate startDate, LocalDate endDate);
//}