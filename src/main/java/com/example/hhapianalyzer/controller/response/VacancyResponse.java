package com.example.hhapianalyzer.controller.response;

import com.example.hhapianalyzer.dto.vacancies.VacancyDto;
import lombok.Data;

import java.util.List;

@Data
public class VacancyResponse {
    private List<VacancyDto> items;
    private int found;
    private int pages;
    private int perPage;
    private int page;
}
