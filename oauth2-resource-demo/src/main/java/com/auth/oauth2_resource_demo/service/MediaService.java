package com.auth.oauth2_resource_demo.service;

import com.auth.oauth2_resource_demo.dto.MediaDTO;
import com.auth.oauth2_resource_demo.mappers.MediaMapper;
import com.auth.oauth2_resource_demo.models.Media;
import com.auth.oauth2_resource_demo.repository.MediaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MediaService {

    private final MediaRepository mediaRepository;

    public List<MediaDTO> getAllMedia() {
        return mediaRepository.findAll()
                .stream()
                .map(MediaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MediaDTO getMediaById(Long id) {
        return mediaRepository.findById(id)
                .map(MediaMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Media not found"));
    }

    public MediaDTO createMedia(MediaDTO dto) {
        Media media = MediaMapper.fromDTO(dto);
        return MediaMapper.toDTO(mediaRepository.save(media));
    }

    public void deleteMedia(Long id) {
        if (!mediaRepository.existsById(id)) {
            throw new EntityNotFoundException("Media not found");
        }
        mediaRepository.deleteById(id);
    }
}