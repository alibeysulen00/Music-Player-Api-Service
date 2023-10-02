package com.example.adayazilim.model.repository;

import com.example.adayazilim.model.entities.Albumler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlbumlerRepo extends JpaRepository<Albumler, Integer> {

    @Query(value = "SELECT COUNT(albumler.sanatci_id) FROM albumler WHERE sanatci_id = :id",nativeQuery = true)
    int getAlbumCount(int id);
}
