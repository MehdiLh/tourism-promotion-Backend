package com.auth.oauth2_resource_demo.mappers;

import com.auth.oauth2_resource_demo.dto.BookingDTO;
import com.auth.oauth2_resource_demo.models.Booking;

public class BookingMapper {

    public static BookingDTO toDTO(Booking booking) {
        return BookingDTO.builder()
                .id(booking.getId())
                .user(UserMapper.toBasicDTO(booking.getUser()))
                .site(TouristSiteMapper.toBasicDTO(booking.getSite()))
                .bookingDate(booking.getBookingDate())
                .status(booking.getStatus())
                .build();
    }

    public static Booking fromDTO(BookingDTO dto) {
        return Booking.builder()
                .id(dto.getId())
                .user(UserMapper.fromBasicDTO(dto.getUser()))
                .site(TouristSiteMapper.fromBasicDTO(dto.getSite()))
                .bookingDate(dto.getBookingDate())
                .status(dto.getStatus())
                .build();
    }
}