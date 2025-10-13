package com.aristeridis.controller;

import com.aristeridis.entity.User;
import com.aristeridis.entity.UserHistory;
import com.aristeridis.service.UserHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/{id}")
    public UserHistory getOne(@PathVariable Long id) { return service.getOne(id); }
}