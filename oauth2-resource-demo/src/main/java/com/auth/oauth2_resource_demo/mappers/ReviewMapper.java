package com.auth.oauth2_resource_demo.mappers;

import com.auth.oauth2_resource_demo.dto.ReviewDTO;
import com.auth.oauth2_resource_demo.models.Review;

public class ReviewMapper {

    public static ReviewDTO toDTO(Review review) {
        return ReviewDTO.builder()
                .id(review.getId())
                .content(review.getContent())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt())
                .user(UserMapper.toBasicDTO(review.getUser()))
                .build();
    }

    public static Review fromDTO(ReviewDTO dto) {
        return Review.builder()
                .id(dto.getId())
                .content(dto.getContent())
                .rating(dto.getRating())
                .createdAt(dto.getCreatedAt())
                .user(UserMapper.fromBasicDTO(dto.getUser()))
                .build();
    }

}