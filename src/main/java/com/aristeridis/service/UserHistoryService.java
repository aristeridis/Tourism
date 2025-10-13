package com.aristeridis.service;

import com.aristeridis.entity.User;
import com.aristeridis.entity.UserHistory;
import com.aristeridis.repository.UserHistoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserHistoryService {
    private final UserHistoryRepository repository;

    public UserHistoryService(UserHistoryRepository repository) {
        this.repository = repository;
    }

    public List<UserHistory> getAll() {
        return repository.findAll();
    }

    public UserHistory save(UserHistory history) {
        return repository.save(history);
    }

    public UserHistory getOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<UserHistory> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}