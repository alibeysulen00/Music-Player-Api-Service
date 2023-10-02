package com.example.adayazilim.model.repository;

import com.example.adayazilim.model.entities.Sarkilar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository

public interface SarkilarRepo extends JpaRepository<Sarkilar, Integer> {

    @Query(value = "SELECT COUNT(sarkilar.sanatci_id) FROM sarkilar WHERE sanatci_id = :id",nativeQuery = true)
    int getSongCount(int id);
}
