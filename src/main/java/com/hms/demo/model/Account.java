package com.hms.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    @JsonIgnore
    @NotNull
    @Column(name = "password_hash", nullable = false)
    private String password;
    @Email
    @Column(name = "email", unique = true)
    private String email;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;
}
