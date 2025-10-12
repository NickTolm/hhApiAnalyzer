package com.example.hhapianalyzer.dto.vacancies;

import lombok.Data;

@Data
public class Searcher {
    private String name;
    private boolean has_test;
    private boolean responseLetterRequired;
    private Area area;
    private boolean onlyWithSalary;
    private Salary salary;
    private String published_at;
    private String created_at;
    private boolean acceptIncompleteResumes;
    private Experience experience;
}
