package org.nbad.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "llm_performance")
public class LLMPerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "llm_id")
    private LLM llm;

    private String version;

    @Column(name = "performance_metric")
    private Double performanceMetric;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LLM getLlm() {
        return llm;
    }

    public void setLlm(LLM llm) {
        this.llm = llm;
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