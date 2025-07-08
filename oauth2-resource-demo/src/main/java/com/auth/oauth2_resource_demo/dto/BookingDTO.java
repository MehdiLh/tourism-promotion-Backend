package com.auth.oauth2_resource_demo.dto;

import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDTO {
    private Long id;
    private UserBasicDTO user;
    private TouristSiteBasicDTO site;
    private Date bookingDate;
    private String status;
}