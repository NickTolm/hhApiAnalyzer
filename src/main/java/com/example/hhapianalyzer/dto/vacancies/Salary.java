package com.example.hhapianalyzer.dto.vacancies;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Salary {
    private int from;
    private int to;
    private String currency;
}
