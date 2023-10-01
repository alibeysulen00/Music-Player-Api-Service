package com.example.adayazilim.model.repository;

import com.example.adayazilim.model.entities.CalmaListeleriSarkilari;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface CalmaListeleriSarkilariRepo extends JpaRepository<CalmaListeleriSarkilari, Integer> {

    @Modifying
    @Transactional
     @Query(value = "DELETE FROM calma_listeleri_sarkilari WHERE calma_listesi_id = :calmaListesiId ",nativeQuery = true)
    void deleteByCalmaListesiId(@Param("calmaListesiId") int calmaListesiId);

}
