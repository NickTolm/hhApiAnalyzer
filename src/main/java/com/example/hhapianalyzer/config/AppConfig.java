package com.example.hhapianalyzer.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class AppConfig {
@Bean
public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();

    // Настройка ObjectMapper для обработки разных форматов
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    converter.setObjectMapper(objectMapper);
    converter.setSupportedMediaTypes(Arrays.asList(
            MediaType.APPLICATION_JSON,
            MediaType.TEXT_HTML,
            MediaType.TEXT_PLAIN
    ));


    // Заменяем стандартный Jackson конвертер нашим
    restTemplate.getMessageConverters().removeIf(
            c -> c instanceof MappingJackson2HttpMessageConverter
    );
    restTemplate.getMessageConverters().add(converter);

    return restTemplate;
}
//@Bean
//public RestTemplate restTemplate() {
//    RestTemplate restTemplate = new RestTemplate();
//    restTemplate.getInterceptors().add((request, body, execution) -> {
//        System.out.println("Request: " + request.getURI());
//        System.out.println("Headers: " + request.getHeaders());
//        return execution.execute(request, body);
//    });
//    return restTemplate;
//}
//@Bean
//public RestTemplate restTemplate() {
//    RestTemplate restTemplate = new RestTemplate();
//
//    ObjectMapper objectMapper = new ObjectMapper();
//    objectMapper.registerModule(new JavaTimeModule());
//    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//    MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
//    messageConverter.setObjectMapper(objectMapper);
//
//    restTemplate.getMessageConverters().removeIf(converter -> converter instanceof MappingJackson2HttpMessageConverter);
//    restTemplate.getMessageConverters().add(messageConverter);
//
//    return restTemplate;
//}

}
