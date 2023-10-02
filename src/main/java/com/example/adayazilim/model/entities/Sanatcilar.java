package com.example.adayazilim.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "sanatcilar")
public class Sanatcilar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    @Column(name = "ad")
    private String ad;
    @Column(name = "kurulus_tarihi")
    private String kurulus_tarihi;



}
