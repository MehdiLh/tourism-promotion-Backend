package com.auth.oauth2_resource_demo.repository;

import com.auth.oauth2_resource_demo.models.Itinerary;
import com.auth.oauth2_resource_demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
    List<Itinerary> findByUser(User user);
}