package com.hms.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patients")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "ethnic")
    private String ethnic;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "job")
    private String job;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "detail_address")
    private String detailAddress;
    @Column(name = "description")
    private String description;
    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
