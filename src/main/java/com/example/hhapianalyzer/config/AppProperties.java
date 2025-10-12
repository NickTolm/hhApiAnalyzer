package com.example.hhapianalyzer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "properties")
@Data
public class AppProperties {
    private String authorization;
    private String url;
}
