package com.example.adayazilim.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "albumler")
public class Albumler {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "ad")
    private String ad;
    @Column(name = "sanatci_id")
    private int sanatciId;
    @Column(name = "cikis_tarihi")
    private String cikis_tarihi;



}
