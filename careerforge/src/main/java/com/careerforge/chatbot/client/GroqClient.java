package com.careerforge.chatbot.client;

import com.careerforge.chatbot.dto.ChatMessageDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Slf4j
@Component
public class GroqClient {

    private static final String GROQ_API_URL = "https://api.groq.com/openai/v1/chat/completions";

    @Value("${app.groq.api-key-1:}")
    private String primaryApiKey;

    @Value("${app.groq.api-key-2:}")
    private String secondaryApiKey;

    @Value("${app.groq.model:llama-3.3-70b-versatile}")
    private String primaryModel;

    @Value("${app.groq.fallback-model:llama-3.1-8b-instant}")
    private String fallbackModel;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public GroqClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(8000); // 8 seconds
        factory.setReadTimeout(18000);   // 18 seconds
        this.restTemplate = new RestTemplate(factory);
    }

    /**
     * Executes chat completion with automatic failover from primary key to secondary key.
     */
    public Optional<String> completeChat(String systemPrompt, List<ChatMessageDto> messages) {
        List<String> keyCandidates = getAvailableKeys();
        if (keyCandidates.isEmpty()) {
            log.info("No Groq API keys configured. Falling back to local CareerForge knowledge base.");
            return Optional.empty();
        }

        // Try primary key first, then secondary key on failure
        for (int i = 0; i < keyCandidates.size(); i++) {
            String apiKey = keyCandidates.get(i);
            String keyLabel = (i == 0) ? "PRIMARY" : "SECONDARY";

            try {
                log.debug("Dispatching request to Groq API using [{}] key and model [{}]", keyLabel, primaryModel);
                String response = executeRequest(apiKey, primaryModel, systemPrompt, messages);
                if (response != null && !response.isBlank()) {
                    return Optional.of(response);
                }
            } catch (HttpStatusCodeException ex) {
                int statusCode = ex.getStatusCode().value();
                log.warn("Groq API [{}] key returned HTTP {}: {}. Attempting failover if another key exists.",
                        keyLabel, statusCode, ex.getStatusText());

                // If on primary key and secondary exists, loop will try secondary next.
            } catch (Exception ex) {
                log.warn("Groq API [{}] key encountered network/timeout error: {}.", keyLabel, ex.getMessage());
            }
        }

        // If primary model failed across keys, attempt fast 8B model with primary or secondary as final safeguard
        for (String apiKey : keyCandidates) {
            try {
                log.info("Attempting backup request with Groq lightweight fallback model [{}]", fallbackModel);
                String fallbackResponse = executeRequest(apiKey, fallbackModel, systemPrompt, messages);
                if (fallbackResponse != null && !fallbackResponse.isBlank()) {
                    return Optional.of(fallbackResponse);
                }
            } catch (Exception ex) {
                log.warn("Fallback model attempt failed: {}", ex.getMessage());
            }
        }

        log.warn("All Groq API keys and models exhausted. Falling back to platform knowledge engine.");
        return Optional.empty();
    }

    private String executeRequest(String apiKey, String model, String systemPrompt, List<ChatMessageDto> messages) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey.trim());

        List<Map<String, String>> messageList = new ArrayList<>();
        if (systemPrompt != null && !systemPrompt.isBlank()) {
            messageList.add(Map.of("role", "system", "content", systemPrompt));
        }

        if (messages != null) {
            for (ChatMessageDto msg : messages) {
                if (msg.getContent() != null && !msg.getContent().isBlank()) {
                    String role = (msg.getRole() != null && msg.getRole().equalsIgnoreCase("assistant")) ? "assistant" : "user";
                    messageList.add(Map.of("role", role, "content", msg.getContent()));
                }
            }
        }

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", model);
        requestBody.put("messages", messageList);
        requestBody.put("max_tokens", 800);
        requestBody.put("temperature", 0.6);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.exchange(GROQ_API_URL, HttpMethod.POST, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            try {
                JsonNode root = objectMapper.readTree(response.getBody());
                JsonNode choices = root.path("choices");
                if (choices.isArray() && !choices.isEmpty()) {
                    return choices.get(0).path("message").path("content").asText();
                }
            } catch (Exception e) {
                log.error("Failed to parse Groq API response JSON: {}", e.getMessage());
            }
        }
        return null;
    }

    private List<String> getAvailableKeys() {
        List<String> keys = new ArrayList<>();
        if (primaryApiKey != null && !primaryApiKey.isBlank() && !primaryApiKey.startsWith("${")) {
            keys.add(primaryApiKey.trim());
        }
        if (secondaryApiKey != null && !secondaryApiKey.isBlank() && !secondaryApiKey.startsWith("${")) {
            keys.add(secondaryApiKey.trim());
        }
        return keys;
    }

    public boolean hasConfiguredKeys() {
        return !getAvailableKeys().isEmpty();
    }
}
