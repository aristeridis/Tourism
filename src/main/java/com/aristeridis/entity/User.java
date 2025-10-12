package com.aristeridis.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(nullable = false, unique = true)
    @JsonProperty("username")
    private String username;

    @Column(nullable = false, unique = true)
    @JsonProperty("email")
    private String email;
    @JsonProperty("preferredcategory")
    private String preferredCategory;
    @JsonProperty("language")
    private String language;
    @JsonProperty("averagerating")
    private Double averageRating = 0.0;
    @JsonProperty("totalvisits")
    private Integer totalVisits = 0;

    public User() {
    }

    public User(Long id, String username, String email, String preferredCategory, String language, Double averageRating, Integer totalVisits) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.preferredCategory = preferredCategory;
        this.language = language;
        this.averageRating = averageRating;
        this.totalVisits = totalVisits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPreferredCategory() {
        return preferredCategory;
    }

    public void setPreferredCategory(String preferredCategory) {
        this.preferredCategory = preferredCategory;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getTotalVisits() {
        return totalVisits;
    }

    public void setTotalVisits(Integer totalVisits) {
        this.totalVisits = totalVisits;
    }
}
