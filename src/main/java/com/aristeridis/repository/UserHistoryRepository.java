package com.aristeridis.repository;

import com.aristeridis.entity.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
    @Query("SELECT u FROM UserHistory u WHERE u.userId = :userId")
    List<UserHistory> findByUserId(Long userId);

}