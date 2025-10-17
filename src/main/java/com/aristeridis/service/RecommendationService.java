package com.aristeridis.service;

import com.aristeridis.entity.Landmark;
import com.aristeridis.entity.User;
import com.aristeridis.entity.UserHistory;
import com.aristeridis.repository.LandmarkRepository;
import com.aristeridis.repository.UserHistoryRepository;
import com.aristeridis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository historyRepository;

    @Autowired
    private LandmarkRepository landmarkRepository;

    public List<Landmark> recommendLandmarksForUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) return Collections.emptyList();

        if (user.getPreferredCategory() != null && !user.getPreferredCategory().isEmpty()) {
            return landmarkRepository.findByCategory(user.getPreferredCategory());
        }

        List<UserHistory> history = historyRepository.findByUserId(userId);
        if (history.isEmpty()) return Collections.emptyList();

        Map<String, Long> categoryCount = history.stream()
                .collect(Collectors.groupingBy(h ->
                        landmarkRepository.findById(h.getLandmarkId())
                                .map(Landmark::getCategory)
                                .orElse("Άγνωστη"), Collectors.counting()));

        String mostVisitedCategory = categoryCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Άγνωστη");

        return landmarkRepository.findByCategory(mostVisitedCategory);
    }

    public List<Landmark> findByUserId(Long userId) {
       return landmarkRepository.findByUserId(userId);
    }
}
