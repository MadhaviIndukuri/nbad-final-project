package org.nbad.backend.dto;

public class LLMParameterDto {
    private Long id;
    private Long llmId; // Represent the LLM entity's ID
    private String version;
    private Long parametersCount;

    // Constructor
    public LLMParameterDto(Long id, Long llmId, String version, Long parametersCount) {
        this.id = id;
        this.llmId = llmId;
        this.version = version;
        this.parametersCount = parametersCount;
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

    public Long getParametersCount() {
        return parametersCount;
    }

    public void setParametersCount(Long parametersCount) {
        this.parametersCount = parametersCount;
    }
}