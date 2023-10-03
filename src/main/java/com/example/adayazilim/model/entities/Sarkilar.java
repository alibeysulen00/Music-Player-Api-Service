package com.example.adayazilim.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "sarkilar")
public class Sarkilar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "album_id")
    private int album_id;

    @Column(name = "sanatci_id")
    private int sanatciId;



}
