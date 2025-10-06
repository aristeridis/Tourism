package com.aristeridis.service;

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
}