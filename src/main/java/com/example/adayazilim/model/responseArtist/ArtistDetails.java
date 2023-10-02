package com.example.adayazilim.model.responseArtist;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "artist_details")
public class ArtistDetails {

    @Column(name = "Sanatci_Adi")
    private String artistName;
    @Column(name = "Toplam_Album_Adedi")
    private long artisAlbumTotal;
    @Column(name = "Toplam_Sarki_Adedi")
    private long countOfSongsInAlbums;

}
