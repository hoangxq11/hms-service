package com.hms.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "health_insurance_cards")
@Data
public class HealthInsuranceCard {
    @Id
    private String id;
    @Column(name = "issue_date")
    private Date issueDate;
    @Column(name = "expiration_date")
    private Date expirationDate;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
