package com.aristeridis.controller;

import com.aristeridis.entity.UserHistory;
import com.aristeridis.service.UserHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "*")
public class UserHistoryController {
    private final UserHistoryService service;

    public UserHistoryController(UserHistoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserHistory> getAll() {
        return service.getAll();
    }

    @PostMapping
    public UserHistory create(@RequestBody UserHistory history) {
        return service.save(history);
    }
}