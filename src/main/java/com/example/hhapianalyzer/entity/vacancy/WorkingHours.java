package com.example.hhapianalyzer.entity.vacancy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "WORKING_HOURS")
@Data
@ToString
public class WorkingHours {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "working_hours_seq")
    @SequenceGenerator(name = "working_hours_seq", sequenceName = "working_hours_seq", allocationSize = 1)
    @Column(name = "WORKING_HOURS_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
}
