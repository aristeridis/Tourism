package com.aristeridis.service;

import com.aristeridis.entity.User;
import com.aristeridis.entity.UserHistory;
import com.aristeridis.repository.UserHistoryRepository;
import com.aristeridis.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserHistoryRepository userHistoryRepository;


    public UserService(UserRepository repository, UserHistoryRepository userHistoryRepository) {
        this.repository = repository;
        this.userHistoryRepository = userHistoryRepository;
    }

    public User updateUserModel(Long userId) {
        User user = repository.findById(userId).orElseThrow();

        Optional<UserHistory> histories = userHistoryRepository.findById(userId);

        int totalVisits = Math.toIntExact(histories.stream().count());
        user.setTotalVisits(totalVisits);

        double averageRating = histories.stream()
                .filter(h -> h.getRating() != null)
                .mapToDouble(UserHistory::getRating)
                .average()
                .orElse(0.0);
        user.setAverageRating(averageRating);

        Map<String, Long> categoryCount = histories.stream()
                .collect(Collectors.groupingBy(UserHistory::getCategory, Collectors.counting()));

        String preferredCategory = categoryCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        user.setPreferredCategory(preferredCategory);

        return repository.save(user);
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
