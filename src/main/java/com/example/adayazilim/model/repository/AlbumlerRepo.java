package com.example.adayazilim.model.repository;

import com.example.adayazilim.model.entities.Albumler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlbumlerRepo extends JpaRepository<Albumler, Integer> {

    // Query ile de sanatci_id değerine göre sarkilar sayısı döndürülebilir. Bunun yerine yeni bir yöntem olan JPA kullandım

   /* @Query(value = "SELECT COUNT(albumler.sanatci_id) FROM albumler WHERE sanatci_id = :id",nativeQuery = true)
    int getAlbumCount(int id);*/

    int countAllBySanatciId(int sanatci_id);

}
