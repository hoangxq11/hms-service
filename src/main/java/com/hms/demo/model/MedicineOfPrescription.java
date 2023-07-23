package com.hms.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "medicine_of_prescription")
@Data
public class MedicineOfPrescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "medicine")
    private Medicine medicine;
    @ManyToOne
    @JoinColumn(name = "prescription")
    private Prescription prescription;
    @Column(name = "quantity")
    private Integer quantity;
}