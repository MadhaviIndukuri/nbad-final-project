package org.nbad.backend.controller;

import org.nbad.backend.dto.LLMParameterDto;
import org.nbad.backend.dto.LLMPerformanceDto;
import org.nbad.backend.dto.LLMResponseDto;
import org.nbad.backend.services.LLMService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LLMController {

    private final LLMService llmService;

    public LLMController(LLMService llmService) {
        this.llmService = llmService;
    }

    @GetMapping("/dashboard")
    public ResponseEntity<List<LLMResponseDto>> getDashboardData() {
        List<LLMResponseDto> data = llmService.getDashboardData();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/summary")
    public ResponseEntity<List<LLMParameterDto>> getSummaryData() {
        List<LLMParameterDto> data = llmService.getSummaryData();
        System.out.println(data);
        return ResponseEntity.ok(data);  // Returns List of LLMParameterDto
    }

    @GetMapping("/reports")
    public ResponseEntity<List<LLMPerformanceDto>> getReportsData() {
        List<LLMPerformanceDto> data = llmService.getReportsData();
        return ResponseEntity.ok(data);  // Returns List of LLMPerformanceDto
    }

    @GetMapping("/chart-data")
    public ResponseEntity<List<Integer>> getChartData() {
        List<Integer> data = llmService.getChartData();
        return ResponseEntity.ok(data);
    }
}