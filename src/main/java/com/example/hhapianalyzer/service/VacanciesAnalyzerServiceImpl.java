package com.example.hhapianalyzer.service;

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


}
