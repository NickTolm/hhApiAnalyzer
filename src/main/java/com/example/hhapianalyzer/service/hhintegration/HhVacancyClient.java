package com.example.hhapianalyzer.service.hhintegration;

import com.example.hhapianalyzer.config.AppProperties;
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

@Component
@RequiredArgsConstructor
public class HhVacancyClient {
    private final AppProperties appProperties;
    private final RestTemplate restTemplate;

    public List<VacancyDto> getVacanciesListByName(Searcher searcher) {
        String url = UriComponentsBuilder.fromHttpUrl(appProperties.getUrl())
                .queryParam("text", searcher.getName())
                .queryParam("area", searcher.getArea().getName())
                .queryParam("salary", searcher.getSalary().getFrom())
                .queryParam("salary", searcher.getSalary().getTo())
                .queryParam("salary", searcher.getSalary().getCurrency())
//                .queryParam("only_with_salary", searcher.getOnlyWithSalary())
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
}
