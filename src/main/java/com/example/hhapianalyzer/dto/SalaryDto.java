package com.example.hhapianalyzer.dto;

import lombok.Data;

@Data
class SalaryDto {
    private Integer from;
    private Integer to;
    private String currency;
}
