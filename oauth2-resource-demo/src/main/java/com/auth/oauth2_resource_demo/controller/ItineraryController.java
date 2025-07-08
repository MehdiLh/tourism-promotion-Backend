package com.auth.oauth2_resource_demo.controller;

import com.auth.oauth2_resource_demo.models.Itinerary;
import com.auth.oauth2_resource_demo.repository.ItineraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itineraries")
@RequiredArgsConstructor
public class ItineraryController {

    private final ItineraryRepository itineraryRepository;

    @GetMapping
    public List<Itinerary> getAllItineraries() {
        return itineraryRepository.findAll();
    }

    @PostMapping
    public Itinerary createItinerary(@RequestBody Itinerary itinerary) {
        return itineraryRepository.save(itinerary);
    }

    @DeleteMapping("/{id}")
    public void deleteItinerary(@PathVariable Long id) {
        itineraryRepository.deleteById(id);
    }
}