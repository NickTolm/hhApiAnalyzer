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
    @Column(name = "salary_id")
    private Long salaryId;

    @Column(name = "SALARY_FROM")
    private int from;

    @Column(name = "SALARY_TO")
    private int to;

    @Column(name = "CURRENCY", length = 3)
    private String currency;
}
