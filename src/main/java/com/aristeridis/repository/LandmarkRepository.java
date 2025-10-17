package com.aristeridis.repository;

import com.aristeridis.entity.Landmark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandmarkRepository extends JpaRepository<Landmark, Long> {
    @Query("SELECT l FROM Landmark l WHERE l.category = :category")
    List<Landmark> findByCategory(String category);
        List<Landmark> findByUserId(Long userId);
}

