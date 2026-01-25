package com.example.hhapianalyzer.entity.vacancy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "WORK_FORMAT")
@Data
@ToString
public class WorkFormat {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workformat_seq")
    @SequenceGenerator(name = "workformat_seq", sequenceName = "workformat_seq", allocationSize = 1)
    @Column(name = "WORKFORMAT_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
}
