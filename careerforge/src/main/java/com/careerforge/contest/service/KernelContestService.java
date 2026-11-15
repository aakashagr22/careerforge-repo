package com.careerforge.contest.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class KernelContestService {

    private static final Logger log = LoggerFactory.getLogger(KernelContestService.class);

    private final RestClient restClient;

    // Cache record with expiration timestamp
    private record CacheEntry(JsonNode data, long expiresAt) {
        boolean isExpired() {
            return System.currentTimeMillis() > expiresAt;
        }
    }

    // In-memory cache for contest listings and leaderboards
    private final Map<String, CacheEntry> contestsCache = new ConcurrentHashMap<>();
    private final Map<String, CacheEntry> leaderboardCache = new ConcurrentHashMap<>();

    // Contests cache TTL: 60 seconds (1 minute)
    private static final long CONTESTS_TTL_MS = 60_000L;
    // Leaderboard cache TTL: 30 seconds
    private static final long LEADERBOARD_TTL_MS = 30_000L;

    public KernelContestService(
            @Value("${kernel.api.url:http://localhost:3000}") String kernelUrl,
            @Value("${kernel.api.key:kernel_secret_key_2026}") String kernelApiKey) {
        log.info("Initializing KernelContestService with URL: {}", kernelUrl);
        this.restClient = RestClient.builder()
                .baseUrl(kernelUrl)
                .defaultHeader("X-Kernel-Api-Key", kernelApiKey)
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public JsonNode getContests(String status) {
        String cacheKey = status != null ? status.toLowerCase() : "all";
        CacheEntry cached = contestsCache.get(cacheKey);

        // 1. Return from memory map if valid
        if (cached != null && !cached.isExpired()) {
            log.debug("Serving contests list from in-memory cache for key: {}", cacheKey);
            return cached.data();
        }

        // 2. Fetch from Kernel on cache miss or expiration
        try {
            JsonNode freshData = restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/api/v1/contests")
                            .queryParam("status", cacheKey)
                            .build())
                    .retrieve()
                    .body(JsonNode.class);

            if (freshData != null) {
                contestsCache.put(cacheKey, new CacheEntry(freshData, System.currentTimeMillis() + CONTESTS_TTL_MS));
            }
            return freshData;
        } catch (Exception e) {
            log.error("Failed to fetch contests from Kernel: {}", e.getMessage());
            // Fallback: serve stale cache if Kernel is temporarily unreachable
            if (cached != null) {
                log.warn("Serving stale cached contests due to Kernel outage");
                return cached.data();
            }
            throw new RuntimeException("Kernel contest service unavailable: " + e.getMessage(), e);
        }
    }

    public JsonNode getLeaderboard(String contestCode) {
        String cacheKey = contestCode.toUpperCase();
        CacheEntry cached = leaderboardCache.get(cacheKey);

        if (cached != null && !cached.isExpired()) {
            log.debug("Serving leaderboard from in-memory cache for contest: {}", cacheKey);
            return cached.data();
        }

        try {
            JsonNode freshData = restClient.get()
                    .uri("/api/v1/contests/{code}/leaderboard", contestCode)
                    .retrieve()
                    .body(JsonNode.class);

            if (freshData != null) {
                leaderboardCache.put(cacheKey, new CacheEntry(freshData, System.currentTimeMillis() + LEADERBOARD_TTL_MS));
            }
            return freshData;
        } catch (Exception e) {
            log.error("Failed to fetch leaderboard for contest {} from Kernel: {}", contestCode, e.getMessage());
            if (cached != null) {
                log.warn("Serving stale cached leaderboard for contest: {}", cacheKey);
                return cached.data();
            }
            throw new RuntimeException("Kernel contest leaderboard unavailable: " + e.getMessage(), e);
        }
    }

    public JsonNode getStudentContests(String studentEmail) {
        // Individual student scorecards are fetched fresh per student request
        try {
            return restClient.get()
                    .uri("/api/v1/students/{email}/contests", studentEmail)
                    .retrieve()
                    .body(JsonNode.class);
        } catch (Exception e) {
            log.error("Failed to fetch student contest history for {} from Kernel: {}", studentEmail, e.getMessage());
            throw new RuntimeException("Kernel student contest history unavailable: " + e.getMessage(), e);
        }
    }

    // Utility to manually flush cache if needed
    public void clearCache() {
        contestsCache.clear();
        leaderboardCache.clear();
        log.info("In-memory contests and leaderboard cache cleared");
    }
}
