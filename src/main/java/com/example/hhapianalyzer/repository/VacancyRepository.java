package com.example.hhapianalyzer.repository;

import com.example.hhapianalyzer.entity.vacancy.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VacancyRepository extends JpaRepository<Vacancy, Long>, JpaSpecificationExecutor<Vacancy> {
    boolean existsById(Long id);
}
