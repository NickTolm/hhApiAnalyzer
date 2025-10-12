package com.example.hhapianalyzer.dto.vacancies;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class HhVacancyResponse {
    private List<VacancyDto> items;
}
