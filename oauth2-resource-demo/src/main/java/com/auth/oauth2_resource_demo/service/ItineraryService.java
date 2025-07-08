package com.auth.oauth2_resource_demo.service;

import com.auth.oauth2_resource_demo.dto.ItineraryDTO;
import com.auth.oauth2_resource_demo.mappers.ItineraryMapper;
import com.auth.oauth2_resource_demo.models.Itinerary;
import com.auth.oauth2_resource_demo.repository.ItineraryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;

    public List<ItineraryDTO> getAllItineraries() {
        return itineraryRepository.findAll()
                .stream()
                .map(ItineraryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ItineraryDTO getItineraryById(Long id) {
        return itineraryRepository.findById(id)
                .map(ItineraryMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Itinerary not found"));
    }

    public ItineraryDTO createItinerary(ItineraryDTO dto) {
        Itinerary itinerary = ItineraryMapper.fromDTO(dto);
        return ItineraryMapper.toDTO(itineraryRepository.save(itinerary));
    }

    public void deleteItinerary(Long id) {
        if (!itineraryRepository.existsById(id)) {
            throw new EntityNotFoundException("Itinerary not found");
        }
        itineraryRepository.deleteById(id);
    }
}