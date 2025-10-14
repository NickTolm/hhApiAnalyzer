package com.example.hhapianalyzer.service.hhintegration;

import com.example.hhapianalyzer.config.AppProperties;
import com.example.hhapianalyzer.config.AppStartupRunner;
import com.example.hhapianalyzer.dto.vacancies.HhVacancyResponse;
import com.example.hhapianalyzer.dto.vacancies.Searcher;
import com.example.hhapianalyzer.dto.vacancies.VacancyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class HhVacancyClient {
    private final AppProperties appProperties;
    private final RestTemplate restTemplate;
    private final AppStartupRunner appStartupRunner;

    public List<VacancyDto> getVacanciesListByName(Searcher searcher) {
        String url = UriComponentsBuilder.fromHttpUrl(appProperties.getUrl())
                .path("/vacancies")
                .queryParam("text", searcher.getName())
                .queryParam("area", getAreaIdByName(searcher.getArea().getName())) // поиск id пришедшего от пользователя города в справочнике при запуске приложения
                .queryParam("salary", ((searcher.getSalary().getFrom() + searcher.getSalary().getTo()) / 2)) //  искать все вакансии, потом из них фильтровать по вилке ЗП от пользователя
                .queryParam("currency", searcher.getSalary().getCurrency())
                .queryParam("only_with_salary", searcher.isOnlyWithSalary())
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", appProperties.getAuthorization());

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<HhVacancyResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                HhVacancyResponse.class);

        return response.getBody().getItems();
    }

    private Integer getAreaIdByName(String cityName) {
        return appStartupRunner.getCitiesMap().entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), cityName))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
