package com.auth.oauth2_resource_demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // image/video
    private String url;

    @ManyToOne
    @JoinColumn(name = "site_id", nullable = false)
    private TouristSite site;
}