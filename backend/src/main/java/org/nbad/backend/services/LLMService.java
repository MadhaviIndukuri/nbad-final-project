package org.nbad.backend.services;

import org.nbad.backend.dto.LLMParameterDto;
import org.nbad.backend.dto.LLMPerformanceDto;
import org.nbad.backend.dto.LLMResponseDto;
import org.nbad.backend.model.LLMParameter;
import org.nbad.backend.model.LLMPerformance;
import org.nbad.backend.repositories.LLMParameterRepository;
import org.nbad.backend.repositories.LLMPerformanceRepository;
import org.nbad.backend.repositories.LLMRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LLMService {

    private final LLMRepository llmRepository;
    private final LLMParameterRepository llmParameterRepository;
    private final LLMPerformanceRepository llmPerformanceRepository;

    public LLMService(LLMRepository llmRepository,
                      LLMParameterRepository llmParameterRepository,
                      LLMPerformanceRepository llmPerformanceRepository) {
        this.llmRepository = llmRepository;
        this.llmParameterRepository = llmParameterRepository;
        this.llmPerformanceRepository = llmPerformanceRepository;
    }

    public List<LLMResponseDto> getDashboardData() {
        return llmRepository.findAll().stream().map(llm -> {
            LLMResponseDto dto = new LLMResponseDto();
            dto.setName(llm.getName());
            dto.setSummary(llm.getSummary());
            dto.setReferenceLink(llm.getReferenceLink());
            return dto;
        }).collect(Collectors.toList());
    }

    // Fetch LLM Summary Data and return as DTOs
    public List<LLMParameterDto> getSummaryData() {
        List<LLMParameter> parameters = llmParameterRepository.findAll();

        // Convert each LLMParameter entity to LLMParameterDto
        List<LLMParameterDto> dtoList = parameters.stream()
                .map(param -> new LLMParameterDto(param.getId(), param.getLlm().getId(), param.getVersion(), param.getParametersCount()))
                .collect(Collectors.toList());

        return dtoList;
    }

    // Fetch LLM Performance Data and return as DTOs
    public List<LLMPerformanceDto> getReportsData() {
        List<LLMPerformance> performances = llmPerformanceRepository.findAll();

        // Convert each LLMPerformance entity to LLMPerformanceDto
        List<LLMPerformanceDto> dtoList = performances.stream()
                .map(performance -> new LLMPerformanceDto(performance.getId(), performance.getLlm().getId(),
                        performance.getVersion(), performance.getPerformanceMetric()))
                .collect(Collectors.toList());

        return dtoList;
    }

    public List<Integer> getChartData() {
        // Simulate some chart data
        return Arrays.asList(65, 59, 80, 81, 56, 55, 40);
    }
}