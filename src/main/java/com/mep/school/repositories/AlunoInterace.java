package com.mep.school.repositories;

import com.mep.school.models.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoInterace extends JpaRepository<AlunoModel, Long> {
}
