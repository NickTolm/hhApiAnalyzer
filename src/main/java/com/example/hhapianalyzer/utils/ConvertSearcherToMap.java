package com.example.hhapianalyzer.utils;

import com.example.hhapianalyzer.dto.vacancies.Searcher;
import com.example.hhapianalyzer.service.hhintegration.CityCollector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ConvertSearcherToMap {


    public Map<String, String> convertSearcherToMap(Searcher searcher) {
        Map<String, String> searcherMap = new HashMap<>();
        if (searcher.getName() != null) {
            searcherMap.put("text", searcher.getName());
        }
        if (searcher.getArea() != null) {
            searcherMap.put("area", searcher.getArea().getName()); // вынести эту логику в сервис
        }
        if (searcher.isOnlyWithSalary()) {
            searcherMap.put("only_with_salary", String.valueOf(true));
        }
        if (searcher.getSalary() != null) {
            searcherMap.put("only_with_salary", String.valueOf(true));
            searcherMap.put("salary", String.valueOf(((searcher.getSalary().getFrom() + searcher.getSalary().getTo()) / 2))); // вынести эту логику в сервис
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
}
