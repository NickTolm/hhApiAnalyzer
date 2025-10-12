package com.example.hhapianalyzer.controller;

import com.example.hhapianalyzer.dto.vacancies.Salary;
import com.example.hhapianalyzer.dto.vacancies.Searcher;
import com.example.hhapianalyzer.dto.vacancies.VacancyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

public interface VacancyController {

    @GetMapping("/getVacancies")
    List<VacancyDto> getVacanciesList(@RequestBody Searcher searcher);



}
