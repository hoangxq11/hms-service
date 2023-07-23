package com.hms.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "medical_reports")
@Data
public class MedicalReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "time")
    private LocalDateTime time;
    @Column(name = "description")
    private String description;
    @Column(name = "unitPrice")
    private Float unitPrice;
    @Column(name = "totalPrice")
    private Float totalPrice;
    @ManyToOne
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;
}
