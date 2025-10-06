package com.aristeridis.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "user_history")
public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "landmark_id", nullable = false)
    private Long landmarkId;

    @Column(name = "visit_date", nullable = false)
    private String visitDate;

    private Double rating;
    private String comment;
}