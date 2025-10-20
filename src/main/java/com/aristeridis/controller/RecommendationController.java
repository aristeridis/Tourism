package com.aristeridis.controller;

import com.aristeridis.entity.Landmark;
import com.aristeridis.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@CrossOrigin(origins = "http://localhost:4200")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Landmark>> getRecommendations(@PathVariable Long userId) {
        List<Landmark> recommendations = recommendationService.recommendLandmarksForUser(userId);
        return ResponseEntity.ok(recommendations);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Landmark>> getLandmarksByUser(@PathVariable Long userId) {
        List<Landmark> landmarks = recommendationService.findByUserId(userId);
        return ResponseEntity.ok(landmarks);
    }
}