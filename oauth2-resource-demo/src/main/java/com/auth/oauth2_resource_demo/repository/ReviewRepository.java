package com.auth.oauth2_resource_demo.repository;

import com.auth.oauth2_resource_demo.models.Review;
import com.auth.oauth2_resource_demo.models.TouristSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findBySite(TouristSite site);
}