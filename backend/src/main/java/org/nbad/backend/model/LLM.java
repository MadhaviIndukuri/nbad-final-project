package org.nbad.backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "llms")
public class LLM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String summary;

    @Column(name = "reference_link")
    private String referenceLink;

    @OneToMany(mappedBy = "llm", cascade = CascadeType.ALL)
    private List<LLMParameter> parameters;

    @OneToMany(mappedBy = "llm", cascade = CascadeType.ALL)
    private List<LLMPerformance> performances;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getReferenceLink() {
        return referenceLink;
    }

    public void setReferenceLink(String referenceLink) {
        this.referenceLink = referenceLink;
    }

    public List<LLMParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<LLMParameter> parameters) {
        this.parameters = parameters;
    }

    public List<LLMPerformance> getPerformances() {
        return performances;
    }

    public void setPerformances(List<LLMPerformance> performances) {
        this.performances = performances;
    }
}
