package com.auth.oauth2_resource_demo.mappers;

import com.auth.oauth2_resource_demo.dto.*;
import com.auth.oauth2_resource_demo.models.*;

import java.util.stream.Collectors;

public class TouristSiteMapper {

    public static TouristSiteDTO toDTO(TouristSite site) {
        return TouristSiteDTO.builder()
                .id(site.getId())
                .name(site.getName())
                .description(site.getDescription())
                .location(site.getLocation())
                .latitude(site.getLatitude())
                .longitude(site.getLongitude())
                .averageRating(site.getAverageRating())
                .media(site.getMedia() != null
                        ? site.getMedia().stream().map(MediaMapper::toDTO).collect(Collectors.toList())
                        : null)
                .reviews(site.getReviews() != null
                        ? site.getReviews().stream().map(ReviewMapper::toDTO).collect(Collectors.toList())
                        : null)
                .build();
    }

    public static TouristSiteBasicDTO toBasicDTO(TouristSite site) {
        return TouristSiteBasicDTO.builder()
                .id(site.getId())
                .name(site.getName())
                .location(site.getLocation())
                .build();
    }

    public static TouristSite fromDTO(TouristSiteDTO dto) {
        return TouristSite.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .location(dto.getLocation())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .averageRating(dto.getAverageRating())
                .media(dto.getMedia() != null
                        ? dto.getMedia().stream().map(MediaMapper::fromDTO).collect(Collectors.toList())
                        : null)
                .reviews(dto.getReviews() != null
                        ? dto.getReviews().stream().map(ReviewMapper::fromDTO).collect(Collectors.toList())
                        : null)
                .build();
    }

    public static TouristSite fromBasicDTO(TouristSiteBasicDTO dto) {
        return TouristSite.builder()
                .id(dto.getId())
                .name(dto.getName())
                .location(dto.getLocation())
                .build();
    }
}