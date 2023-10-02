package com.example.adayazilim.model.repository;

import com.example.adayazilim.model.entities.Sanatcilar;
import com.example.adayazilim.model.responseArtist.ArtistDetails;
import com.example.adayazilim.model.responseArtist.ResponseArtist;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;


@Repository
@EnableJpaRepositories
public interface  SanatcilarRepo extends JpaRepository<Sanatcilar, Integer> {

  /*  @Modifying
    @Transactional
    @Query(value = " SELECT\n" +
            "    s.ad as Sanatci_Adi,\n" +
            "    COUNT(DISTINCT a.id) as Toplam_Album_Adedi,\n" +
            "    COUNT(s2.id) as Toplam_Sarki_Adedi\n" +
            "\n" +
            "\n" +
            "    FROM sanatcilar s\n" +
            "    LEFT JOIN albumler a ON s.id = a.sanatci_id\n" +
            "    LEFT JOIN sarkilar s2 ON a.id = s2.album_id\n" +
            "    GROUP BY s.ad\n" +
            "    ORDER BY COUNT(s2.id) DESC, COUNT(DISTINCT  a.id) ASC;",nativeQuery = true)
    List<Object> getSanatcilarAlbumCount();
*/
}
