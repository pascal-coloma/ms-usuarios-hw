package com.usuarios_hw.MS.Usuarios.HW.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 13, nullable = false)
    private String run;

    @Column(nullable = false)
    private String dvrun;

    @Column(nullable = false)
    private String pnombre;

    @Column(nullable = true)
    private String snombre;

    @Column(nullable = false)
    private String appaterno;

    @Column(nullable = false)
    private String apmaterno;

    @Column(nullable = true)
    private Date fechaNacto;




}
