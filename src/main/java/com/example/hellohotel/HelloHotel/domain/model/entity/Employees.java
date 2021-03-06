package com.example.hellohotel.HelloHotel.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employees extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(unique = true)
    private String name;


    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column
    private String Type;

    @Column
    private int Salary;

    // relationShip

    @ManyToOne(fetch = FetchType.LAZY,
    cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="Hotel_Id",nullable = false)
    @JsonIgnore
    private Hotel hotel;
}
