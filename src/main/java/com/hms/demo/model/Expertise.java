package com.hms.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "expertises")
@Data
public class Expertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
}
