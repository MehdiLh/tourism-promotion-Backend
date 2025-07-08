package com.auth.oauth2_resource_demo.service;

import com.auth.oauth2_resource_demo.dto.TouristSiteDTO;
import com.auth.oauth2_resource_demo.mappers.TouristSiteMapper;
import com.auth.oauth2_resource_demo.models.TouristSite;
import com.auth.oauth2_resource_demo.repository.TouristSiteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TouristSiteService {

    private final TouristSiteRepository siteRepository;

    public List<TouristSiteDTO> getAllSites() {
        return siteRepository.findAll()
                .stream()
                .map(TouristSiteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TouristSiteDTO getSiteById(Long id) {
        TouristSite site = siteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TouristSite not found with id " + id));
        return TouristSiteMapper.toDTO(site);
    }

    public TouristSiteDTO createSite(TouristSiteDTO dto) {
        TouristSite site = TouristSiteMapper.fromDTO(dto);
        TouristSite saved = siteRepository.save(site);
        return TouristSiteMapper.toDTO(saved);
    }

    public TouristSiteDTO updateSite(Long id, TouristSiteDTO dto) {
        TouristSite existing = siteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TouristSite not found"));

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setLocation(dto.getLocation());
        existing.setLatitude(dto.getLatitude());
        existing.setLongitude(dto.getLongitude());

        TouristSite updated = siteRepository.save(existing);
        return TouristSiteMapper.toDTO(updated);
    }

    public void deleteSite(Long id) {
        if (!siteRepository.existsById(id)) {
            throw new EntityNotFoundException("TouristSite not found");
        }
        siteRepository.deleteById(id);
    }
}