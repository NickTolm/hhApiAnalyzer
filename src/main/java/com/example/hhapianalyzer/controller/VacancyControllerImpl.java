package com.example.hhapianalyzer.controller;

import com.example.hhapianalyzer.entity.vacancy.Searcher;
import com.example.hhapianalyzer.entity.vacancy.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.hhapianalyzer.service.VacanciesAnalyzerServiceImpl;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VacancyControllerImpl implements VacancyController {
    private final VacanciesAnalyzerServiceImpl vacanciesAnalyzerService;

    @GetMapping("/getVacancies")
    public List<Vacancy> getVacanciesList(@RequestBody Searcher searcher) {
        return vacanciesAnalyzerService.getVacanciesList(searcher);
    }

    @GetMapping("/getAverageSalary") // считает среднюю зп для списка вакансий по критериям
    public double getAverageSalaryForVacancyListByName(@RequestBody Searcher searcher) {
        return vacanciesAnalyzerService.getAverageSalaryForVacancyListByName(searcher);
    }

}
