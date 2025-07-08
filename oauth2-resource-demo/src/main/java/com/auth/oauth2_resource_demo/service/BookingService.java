package com.auth.oauth2_resource_demo.service;

import com.auth.oauth2_resource_demo.dto.BookingDTO;
import com.auth.oauth2_resource_demo.mappers.BookingMapper;
import com.auth.oauth2_resource_demo.models.Booking;
import com.auth.oauth2_resource_demo.repository.BookingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(BookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookingDTO getBookingById(Long id) {
        return bookingRepository.findById(id)
                .map(BookingMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found"));
    }

    public BookingDTO createBooking(BookingDTO dto) {
        Booking booking = BookingMapper.fromDTO(dto);
        return BookingMapper.toDTO(bookingRepository.save(booking));
    }

    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new EntityNotFoundException("Booking not found");
        }
        bookingRepository.deleteById(id);
    }
}