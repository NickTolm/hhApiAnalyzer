package com.example.hhapianalyzer.entity.vacancy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


@Entity
@Table(name = "AREA")
@Data
@ToString
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area_seq")
    @SequenceGenerator(name = "area_seq", sequenceName = "area_seq", allocationSize = 1)
    @Column(name = "AREA_ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;
}
