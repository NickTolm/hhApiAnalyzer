package com.example.hhapianalyzer.entity.vacancy;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


@Entity
@Table(name = "EXPERIENCE")
@Data
@ToString
public class Experience {
    @Id
    @Column(name = "EXPERIENCE_ID")
    private String id;

    @Column(name = "NAME")
    private String name;
}
