package com.hms.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "services_of_medical_test")
@Data
public class ServicesOfMedicalTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "medical_test_id")
    private MedicalTest medicalTest;
    @ManyToOne
    @JoinColumn(name = "services_id")
    private Services services;
    @Column(name = "quantity")
    private Integer quantity;
}