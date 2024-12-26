package com.busanit501.kimdh.repository;

import com.busanit501.kimdh.domain.food_Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ReplyRepository extends JpaRepository<food_Reply, Long> {
    @Query("select r from food_Reply r where r.food.id = : id")
    Page<food_Reply> listOfFood(Long id, Pageable pageable);
}
