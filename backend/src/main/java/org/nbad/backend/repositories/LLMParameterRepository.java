package org.nbad.backend.repositories;

import org.nbad.backend.model.LLMParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LLMParameterRepository extends JpaRepository<LLMParameter, Long> {
    // Custom queries, if needed
}