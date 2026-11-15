package com.careerforge.contest.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class KernelContestService {

    private static final Logger log = LoggerFactory.getLogger(KernelContestService.class);

    private final RestClient restClient;

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
        try {
            return restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/api/v1/contests")
                            .queryParam("status", status != null ? status : "all")
                            .build())
                    .retrieve()
                    .body(JsonNode.class);
        } catch (Exception e) {
            log.error("Failed to fetch contests from Kernel: {}", e.getMessage());
            throw new RuntimeException("Kernel contest service unavailable: " + e.getMessage(), e);
        }
    }

    public JsonNode getLeaderboard(String contestCode) {
        try {
            return restClient.get()
                    .uri("/api/v1/contests/{code}/leaderboard", contestCode)
                    .retrieve()
                    .body(JsonNode.class);
        } catch (Exception e) {
            log.error("Failed to fetch leaderboard for contest {} from Kernel: {}", contestCode, e.getMessage());
            throw new RuntimeException("Kernel contest leaderboard unavailable: " + e.getMessage(), e);
        }
    }

    public JsonNode getStudentContests(String studentEmail) {
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
}
