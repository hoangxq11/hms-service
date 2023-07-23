package com.hms.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "staffs")
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "ethnic")
    private String ethnic;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "detail_address")
    private String detailAddress;
    @ManyToOne
    @JoinColumn(name = "expertise_id")
    private Expertise expertise;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @Column(name = "description")
    private String description;
    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;
}