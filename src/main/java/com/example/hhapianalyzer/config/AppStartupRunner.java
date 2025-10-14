package com.example.hhapianalyzer.config;

import com.example.hhapianalyzer.dto.AreaHhDto.AreaHhDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AppStartupRunner {
    private final AppProperties appProperties;
    private final RestTemplate restTemplate;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Cacheable(value = "citiesMap", cacheManager = "startupCacheManager")
    public Map<Integer, String> getCitiesMap() {
        return makeHttpRequestOnStartup();
    }

    @EventListener(ApplicationReadyEvent.class)
    public Map<Integer, String> makeHttpRequestOnStartup() {
        try {
            String url = UriComponentsBuilder.fromHttpUrl(appProperties.getUrl())
                    .path("/areas")
                    .toUriString();

            // Получаем ответ как строку
            String response = restTemplate.getForObject(url, String.class);

            // Парсим JSON строку напрямую в List<AreaHhDto>
            List<AreaHhDto> rootAreas = objectMapper.readValue(response,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, AreaHhDto.class));

            return collectCitiesRecursive(rootAreas).stream()
                    .filter(area -> area.getLat() != null && area.getLng() != null)
                    .collect(Collectors.toMap(
                            AreaHhDto::getId,
                            AreaHhDto::getName,
                            (existing, replacement) -> existing
                    ));
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse areas", e);
        }
    }

    private static List<AreaHhDto> collectCitiesRecursive(List<AreaHhDto> areas) {
        List<AreaHhDto> allAreas = new ArrayList<>();

        for (AreaHhDto area : areas) {
            allAreas.add(area);
            if (area.getAreas() != null) {
                allAreas.addAll(collectCitiesRecursive(area.getAreas()));
            }
        }

        return allAreas;
    }


}
