package com.example.adayazilim.model.repository;

import com.example.adayazilim.model.entities.Albumler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumlerRepo extends JpaRepository<Albumler, Integer> {



}
