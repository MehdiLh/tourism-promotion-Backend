package com.auth.oauth2_resource_demo.service;

import com.auth.oauth2_resource_demo.dto.ReviewDTO;
import com.auth.oauth2_resource_demo.mappers.ReviewMapper;
import com.auth.oauth2_resource_demo.models.Review;
import com.auth.oauth2_resource_demo.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(ReviewMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ReviewDTO getReviewById(Long id) {
        return reviewRepository.findById(id)
                .map(ReviewMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Review not found"));
    }

    public ReviewDTO createReview(ReviewDTO dto) {
        Review review = ReviewMapper.fromDTO(dto);
        return ReviewMapper.toDTO(reviewRepository.save(review));
    }

    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new EntityNotFoundException("Review not found");
        }
        reviewRepository.deleteById(id);
    }
}