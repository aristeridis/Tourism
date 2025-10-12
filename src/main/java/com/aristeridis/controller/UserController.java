package com.aristeridis.controller;

import com.aristeridis.entity.User;
import com.aristeridis.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService service;

    public UserController(UserService service) { this.service = service; }

    @GetMapping
    public List<User> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id) { return service.getOne(id); }

    @PostMapping
    public User create(@RequestBody User user) { return service.save(user); }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return service.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }

    @GetMapping("/{userId}/model")
    public User getUserModel(@PathVariable Long userId) {
        return service.updateUserModel(userId);
    }
}
