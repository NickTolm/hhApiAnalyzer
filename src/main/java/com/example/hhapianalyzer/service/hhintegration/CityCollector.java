package com.example.hhapianalyzer.service.hhintegration;

import com.example.hhapianalyzer.config.AppProperties;
import com.example.hhapianalyzer.dto.AreaHhDto.AreaHhDto;
//import com.example.hhapianalyzer.repository.AreaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CityCollector {
    private final AppProperties appProperties;
    private final RestTemplate restTemplate;
    private Map<String, Integer> map;
    private static final ObjectMapper objectMapper = new ObjectMapper();
//    private final AreaRepository areaRepository;

    public Integer getLocationById(String name) {
        return map.get(name);
    }

    @PostConstruct
    private void collectCities() {
        String url = UriComponentsBuilder.fromHttpUrl(appProperties.getUrl())
                .path("/areas")
                .toUriString();

        String response = restTemplate.getForObject(url, String.class);

        List<AreaHhDto> rootAreas;
        try {
            rootAreas = objectMapper.readValue(response,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, AreaHhDto.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


        map = collectCitiesRecursive(rootAreas).stream()
                .filter(area -> area.getLat() != null && area.getLng() != null)
                .collect(Collectors.toMap(
                        AreaHhDto::getName,
                        AreaHhDto::getId,
                        (existing, replacement) -> existing
                ));

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
