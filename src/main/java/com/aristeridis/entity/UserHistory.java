package com.aristeridis.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "user_history")
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "user_id", nullable = false)
    @JsonProperty("userId")
    private Long userId;

    @Column(name = "landmark_id", nullable = false)
    @JsonProperty("landmarkId")
    private Long landmarkId;

    @Column(name = "visit_date", nullable = false)
    @JsonProperty("visitDate")
    private String visitDate;

    @JsonProperty("rating")
    private Double rating;

    @JsonProperty("comment")
    private String comment;

    public UserHistory() {}

    public UserHistory(Long userId, Long landmarkId, String visitDate, Double rating, String comment) {
        this.userId = userId;
        this.landmarkId = landmarkId;
        this.visitDate = visitDate;
        this.rating = rating;
        this.comment = comment;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getLandmarkId() { return landmarkId; }
    public void setLandmarkId(Long landmarkId) { this.landmarkId = landmarkId; }

    public String getVisitDate() { return visitDate; }
    public void setVisitDate(String visitDate) { this.visitDate = visitDate; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }
}
