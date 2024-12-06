package org.nbad.backend.repositories;

import org.nbad.backend.model.LLM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LLMRepository extends JpaRepository<LLM, Long> {
}