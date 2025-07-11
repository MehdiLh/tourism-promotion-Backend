package com.auth.oauth2_resource_demo.repository;

import com.auth.oauth2_resource_demo.models.Booking;
import com.auth.oauth2_resource_demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
}
