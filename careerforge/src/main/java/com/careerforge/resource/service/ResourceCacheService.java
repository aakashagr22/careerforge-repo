package com.careerforge.resource.service;

import com.careerforge.resource.dto.FolderDirectoryDto;
import com.careerforge.resource.dto.ResourceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * High-speed in-memory cache for study resources and directory hierarchies.
 * Eliminates repeated multi-table SQL queries during high-concurrency student browsing.
 */
@Service
@Slf4j
public class ResourceCacheService {

    // Cache for folder directory hierarchies (breadcrumbs, child folders, resource listings)
    private final Map<String, FolderDirectoryDto> directoryCache = new ConcurrentHashMap<>();

    // Cache for individual resource details by UUID
    private final Map<UUID, ResourceDto> resourceDetailsCache = new ConcurrentHashMap<>();

    // Cache for filtered/searched resource pages
    private final Map<String, Page<ResourceDto>> resourceSearchCache = new ConcurrentHashMap<>();

    // Directory Cache Accessors
    public FolderDirectoryDto getDirectory(String key) {
        return directoryCache.get(key);
    }

    public void putDirectory(String key, FolderDirectoryDto dto) {
        directoryCache.put(key, dto);
    }

    public void clearDirectoryCache() {
        directoryCache.clear();
        log.info("Resource directory cache invalidated");
    }

    // Resource Details Cache Accessors
    public ResourceDto getResource(UUID id) {
        return resourceDetailsCache.get(id);
    }

    public void putResource(UUID id, ResourceDto dto) {
        resourceDetailsCache.put(id, dto);
    }

    public void evictResource(UUID id) {
        resourceDetailsCache.remove(id);
    }

    // Resource Search Cache Accessors
    public Page<ResourceDto> getSearch(String key) {
        return resourceSearchCache.get(key);
    }

    public void putSearch(String key, Page<ResourceDto> page) {
        resourceSearchCache.put(key, page);
    }

    public void clearSearchCache() {
        resourceSearchCache.clear();
        log.info("Resource search cache invalidated");
    }

    // Invalidate all caches on destructive updates
    public void invalidateAll() {
        directoryCache.clear();
        resourceSearchCache.clear();
        resourceDetailsCache.clear();
        log.info("All resource caches invalidated");
    }
}
