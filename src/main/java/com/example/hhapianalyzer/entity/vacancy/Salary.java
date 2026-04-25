package com.example.hhapianalyzer.entity.vacancy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "SALARY")
@Data
@ToString
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SALARY_ID")
    private Long salaryId;

    @Column(name = "SALARY_FROM")
    private long from;

    @Column(name = "SALARY_TO")
    private long to;

    @Column(name = "CURRENCY", length = 3)
    private String currency;
}
