package org.nbad.backend.repositories;

import org.nbad.backend.model.LLMPerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LLMPerformanceRepository extends JpaRepository<LLMPerformance, Long> {
    // Custom queries, if needed
}