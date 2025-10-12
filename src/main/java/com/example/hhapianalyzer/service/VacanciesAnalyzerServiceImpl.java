package com.example.hhapianalyzer.service;

import com.example.hhapianalyzer.dto.vacancies.Salary;
import com.example.hhapianalyzer.dto.vacancies.Searcher;
import com.example.hhapianalyzer.dto.vacancies.VacancyDto;
import com.example.hhapianalyzer.service.hhintegration.HhVacancyClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacanciesAnalyzerServiceImpl implements VacanciesAnalyzerService {
    private final HhVacancyClient hhVacancyClient;
    public List<VacancyDto> getVacanciesListByName(Searcher searcher) {
        return hhVacancyClient.getVacanciesListByName(searcher);
    }



    private int[] parseExperience(String experienceRange) {
        String[] parts = experienceRange.split("\\D+"); // разделяем по не-цифрам
        int from = Integer.parseInt(parts[1]); // parts[0] будет пустой строкой
        int to = Integer.parseInt(parts[2]);

        return new int[]{from, to};
    }

    public static double calculateAverageSalary(List<VacancyDto> vacancies) {
        if (vacancies == null || vacancies.isEmpty()) {
            return 0.0;
        }

        double totalSum = 0;
        int count = 0;

        for (VacancyDto vacancy : vacancies) {
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
