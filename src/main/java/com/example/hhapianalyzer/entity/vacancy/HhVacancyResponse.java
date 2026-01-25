package com.example.hhapianalyzer.entity.vacancy;

import lombok.Data;
import lombok.ToString;
import java.util.List;

@Data
@ToString
public class HhVacancyResponse {
    private List<Vacancy> items;
}
