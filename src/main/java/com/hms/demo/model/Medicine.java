package com.hms.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "medicines")
@Data
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "use_manual")
    private String useManual;
    @Column(name = "unit")
    private String unit;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Float price;
    @Column(name = "active_element")
    private String activeElement;
    @Column(name = "content")
    private String content;
    @Column(name = "using")
    private String using;
    @Column(name = "packing")
    private String packing;
    @Column(name = "production_unit")
    private String productionUnit;
    @Column(name = "declaring_unit")
    private String declaringUnit;
}
