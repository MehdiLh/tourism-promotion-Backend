package com.auth.oauth2_resource_demo.mappers;

import com.auth.oauth2_resource_demo.dto.ItineraryDTO;
import com.auth.oauth2_resource_demo.models.Itinerary;

import java.util.stream.Collectors;

public class ItineraryMapper {

    public static ItineraryDTO toDTO(Itinerary itinerary) {
        return ItineraryDTO.builder()
                .id(itinerary.getId())
                .user(UserMapper.toBasicDTO(itinerary.getUser()))
                .sites(itinerary.getSites().stream()
                        .map(TouristSiteMapper::toBasicDTO)
                        .collect(Collectors.toList()))
                .startDate(itinerary.getStartDate())
                .endDate(itinerary.getEndDate())
                .build();
    }

    public static Itinerary fromDTO(ItineraryDTO dto) {
        return Itinerary.builder()
                .id(dto.getId())
                .user(UserMapper.fromBasicDTO(dto.getUser()))
                .sites(dto.getSites().stream()
                        .map(TouristSiteMapper::fromBasicDTO)
                        .collect(Collectors.toList()))
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }
}