package com.example.hhapianalyzer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class VacancyDto {
    private String id;
    private String name;

    @JsonProperty("has_test")
    private boolean hasTest;

    @JsonProperty("response_letter_required")
    private boolean responseLetterRequired;

    private AreaDto area;
    private SalaryDto salary;

    @JsonProperty("published_at")
    private String publishedAt;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("work_format")
    private List<WorkFormatDto> workFormat;

    @JsonProperty("working_hours")
    private List<WorkingHoursDto> workingHours;

    @JsonProperty("accept_incomplete_resumes")
    private boolean acceptIncompleteResumes;

    private ExperienceDto experience;
}
