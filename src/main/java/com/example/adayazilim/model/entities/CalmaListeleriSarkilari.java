package com.example.adayazilim.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "calma_listeleri_sarkilari")
public class CalmaListeleriSarkilari {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    @Column(name = "calma_listesi_id")
    private int calma_listesi_id;
    @Column(name = "sarki_id")
    private int sarki_id;
}
