package com.auth.oauth2_resource_demo.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "site_id", nullable = false)
    private TouristSite site;

    private Date bookingDate;
    private String status; // CONFIRMED, CANCELLED, etc.
}