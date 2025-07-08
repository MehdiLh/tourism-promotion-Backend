package com.auth.oauth2_resource_demo.controller;

import com.auth.oauth2_resource_demo.models.TouristSite;
import com.auth.oauth2_resource_demo.repository.TouristSiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sites")
@RequiredArgsConstructor
public class TouristSiteController {

    private final TouristSiteRepository siteRepository;

    @GetMapping
    public List<TouristSite> getAllSites() {
        return siteRepository.findAll();
    }

    @GetMapping("/{id}")
    public TouristSite getSite(@PathVariable Long id) {
        return siteRepository.findById(id).orElse(null);
    }

    @PostMapping
    public TouristSite createSite(@RequestBody TouristSite site) {
        return siteRepository.save(site);
    }

    @PutMapping("/{id}")
    public TouristSite updateSite(@PathVariable Long id, @RequestBody TouristSite updatedSite) {
        updatedSite.setId(id);
        return siteRepository.save(updatedSite);
    }

    @DeleteMapping("/{id}")
    public void deleteSite(@PathVariable Long id) {
        siteRepository.deleteById(id);
    }
}