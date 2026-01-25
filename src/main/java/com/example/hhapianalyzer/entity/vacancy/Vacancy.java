package com.example.hhapianalyzer.entity.vacancy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "VACANCY")
@Data
@ToString
public class Vacancy {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "HAS_TEST")
    private boolean hasTest;

    @Column(name = "RESPONSE_LETTER_REQUIRED")
    private boolean responseLetterRequired;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AREA_ID")
    private Area area;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id", referencedColumnName = "salary_id")
    private Salary salary;

    @Column(name = "PUBLISHED_AT")
    private String publishedAt;

    @Column(name = "CREATED_AT")
    private String createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WORK_FORMAT_ID")
    private WorkFormat workFormat;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "WORKING_HOURS_ID")
    private WorkingHours workingHours;

    @Column(name = "ACCEPT_IN_COMPLETE_RESUMES")
    private boolean acceptIncompleteResumes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "EXPERIENCE_ID")
    private Experience experience;

}
