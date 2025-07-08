package com.auth.oauth2_resource_demo.mappers;

import com.auth.oauth2_resource_demo.dto.MediaDTO;
import com.auth.oauth2_resource_demo.models.Media;

public class MediaMapper {

    public static MediaDTO toDTO(Media media) {
        return MediaDTO.builder()
                .id(media.getId())
                .type(media.getType())
                .url(media.getUrl())
                .build();
    }

    public static Media fromDTO(MediaDTO dto) {
        return Media.builder()
                .id(dto.getId())
                .type(dto.getType())
                .url(dto.getUrl())
                .build();
    }
}