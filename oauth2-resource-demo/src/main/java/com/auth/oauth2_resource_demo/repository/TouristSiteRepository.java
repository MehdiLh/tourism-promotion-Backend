package com.auth.oauth2_resource_demo.repository;

import com.auth.oauth2_resource_demo.models.TouristSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristSiteRepository extends JpaRepository<TouristSite, Long> {
    // Example custom query
    TouristSite findByName(String name);
}