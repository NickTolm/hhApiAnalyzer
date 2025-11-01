package com.example.hhapianalyzer.service;

import com.example.hhapianalyzer.dto.vacancies.Salary;
import com.example.hhapianalyzer.dto.vacancies.Searcher;
import com.example.hhapianalyzer.dto.vacancies.VacancyDto;
import com.example.hhapianalyzer.service.hhintegration.CityCollector;
import com.example.hhapianalyzer.service.hhintegration.HhVacancyClient;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class VacanciesAnalyzerServiceImpl implements VacanciesAnalyzerService {
    private final HhVacancyClient hhVacancyClient;
    private final CityCollector cityCollector;

    public List<VacancyDto> getVacanciesListByName(Searcher searcher) {

        Map<String, String> searcherMap = convertSearcherToMap(searcher);

        List<VacancyDto> vacancyDtoListHh = hhVacancyClient.getVacanciesListByName(searcherMap);
        List<VacancyDto> vacancyDtoList = new ArrayList<>();
        if (searcher.getSalary() != null) {
            for (VacancyDto vacancyDto : vacancyDtoListHh) {
                if ((searcher.getSalary().getFrom() <= vacancyDto.getSalary().getFrom())) {
                    vacancyDtoList.add(vacancyDto);
                }
            }
        }
        return vacancyDtoList;
    }

    private Map<String, String> convertSearcherToMap(Searcher searcher) {
        Map<String, String> searcherMap = new HashMap<>();
        if (searcher.getName() != null) {
            searcherMap.put("text", searcher.getName());
        }
        if (searcher.getArea() != null) {
            searcherMap.put("area", cityCollector.getLocationById(searcher.getArea().getName()).toString());
        }
        if (searcher.isOnlyWithSalary()) {
            searcherMap.put("only_with_salary", String.valueOf(true));
        }
        if (searcher.getSalary() != null) {
            searcherMap.put("salary", String.valueOf(((searcher.getSalary().getFrom() + searcher.getSalary().getTo()) / 2)));
        }
        if (searcher.getPublishedAt() != null) {
            searcherMap.put("published_at", searcher.getPublishedAt());
        }
        if (searcher.getCreatedAt() != null) {
            searcherMap.put("created_at", searcher.getCreatedAt());
        }
        if (searcher.getExperience() != null) {
            searcherMap.put("experience", searcher.getExperience().getId());
        }
            return searcherMap;
    }


    private int[] parseExperience(String experienceRange) {
        String[] parts = experienceRange.split("\\D+"); // разделяем по не-цифрам
        int from = Integer.parseInt(parts[1]); // parts[0] будет пустой строкой
        int to = Integer.parseInt(parts[2]);

        return new int[]{from, to};
    }

    public double getAverageSalaryForVacancyListByName(Searcher searcher) {
        List<VacancyDto> vacanciesList = getVacanciesListByName(searcher);
        if (vacanciesList == null || vacanciesList.isEmpty()) {
            return 0.0;
        }

        double totalSum = 0;
        int count = 0;

        for (VacancyDto vacancy : vacanciesList) {
            Salary salary = vacancy.getSalary();

            // Пропускаем вакансии без зарплаты
            if (salary == null) {
                continue;
            }

            // Рассчитываем среднюю для текущей вакансии
            double averageForVacancy = calculateAverageForVacancy(salary);

            if (averageForVacancy > 0) {
                totalSum += averageForVacancy;
                count++;
            }
        }

        return count > 0 ? totalSum / count : 0.0;
    }

    private static double calculateAverageForVacancy(Salary salary) {
        // Если указаны обе границы, берем среднее арифметическое
        if (salary.getFrom() > 0 && salary.getTo() > 0) {
            return (salary.getFrom() + salary.getTo()) / 2.0;
        }
        // Если указана только нижняя граница
        else if (salary.getFrom() > 0) {
            return salary.getFrom();
        }
        // Если указана только верхняя граница
        else if (salary.getTo() > 0) {
            return salary.getTo();
        }
        // Если зарплата не указана
        else {
            return 0;
        }
    }
}
