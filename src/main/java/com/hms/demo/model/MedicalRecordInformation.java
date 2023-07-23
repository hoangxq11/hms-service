package com.hms.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "medical_record_informations")
@Data
public class MedicalRecordInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "weight")
    private Float weight;
    @Column(name = "height")
    private Float height;
    @Column(name = "body_temperature")
    private Float bodyTemperature;
    @Column(name = "heartbeat")
    private Float heartbeat;
    @Column(name = "blood_pressure")
    private Float bloodPressure;
    @Column(name = "detail_medical", columnDefinition = "TEXT")
    private String detailMedical;
    @Column(name = "diagnose")
    private String diagnose;
    @Column(name = "solution")
    private String solution;
    @OneToOne
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;
}
