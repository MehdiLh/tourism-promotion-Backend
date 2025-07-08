package com.auth.oauth2_resource_demo.dto;

import lombok.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItineraryDTO {
    private Long id;
    private UserBasicDTO user;
    private List<TouristSiteBasicDTO> sites;
    private Date startDate;
    private Date endDate;
}