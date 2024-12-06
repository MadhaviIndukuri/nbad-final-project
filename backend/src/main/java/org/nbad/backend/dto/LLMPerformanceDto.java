package org.nbad.backend.dto;

public class LLMPerformanceDto {
    private Long id;
    private Long llmId; // Represent the LLM entity's ID
    private String version;
    private Double performanceMetric;

    // Constructor
    public LLMPerformanceDto(Long id, Long llmId, String version, Double performanceMetric) {
        this.id = id;
        this.llmId = llmId;
        this.version = version;
        this.performanceMetric = performanceMetric;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLlmId() {
        return llmId;
    }

    public void setLlmId(Long llmId) {
        this.llmId = llmId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Double getPerformanceMetric() {
        return performanceMetric;
    }

    public void setPerformanceMetric(Double performanceMetric) {
        this.performanceMetric = performanceMetric;
    }
}