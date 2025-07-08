package com.auth.oauth2_resource_demo.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TouristSite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String location; // Could be enhanced with Coordinates embeddable
    private Double latitude;
    private Double longitude;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL)
    private List<Media> media;

    @OneToMany(mappedBy = "site", cascade = CascadeType.ALL)
    private List<Review> reviews;

    private double averageRating;
}