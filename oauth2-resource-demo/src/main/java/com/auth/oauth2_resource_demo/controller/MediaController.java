package com.auth.oauth2_resource_demo.controller;

import com.auth.oauth2_resource_demo.models.Media;
import com.auth.oauth2_resource_demo.repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaRepository mediaRepository;

    @GetMapping
    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    @PostMapping
    public Media createMedia(@RequestBody Media media) {
        return mediaRepository.save(media);
    }

    @DeleteMapping("/{id}")
    public void deleteMedia(@PathVariable Long id) {
        mediaRepository.deleteById(id);
    }
}