package com.example.hhapianalyzer.controller;

import com.example.hhapianalyzer.entity.vacancy.Searcher;
import com.example.hhapianalyzer.entity.vacancy.Vacancy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface VacancyController {

    @GetMapping("/getVacancies")
    List<Vacancy> getVacanciesList(@RequestBody Searcher searcher);



}
