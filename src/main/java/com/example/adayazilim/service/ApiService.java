package com.example.adayazilim.service;


import com.example.adayazilim.exceptions.CustomException;
import com.example.adayazilim.model.entities.*;
import com.example.adayazilim.model.repository.*;
import com.example.adayazilim.model.responseArtist.ArtistDetails;
import com.example.adayazilim.model.responseArtist.ResponseArtist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class ApiService {


    @Autowired
    SarkilarRepo sarkilarRepo;
    @Autowired
    SanatcilarRepo sanatcilarRepo;
    @Autowired
    AlbumlerRepo albumlerRepo;
    @Autowired
    CalmaListeleriRepo calmaListeleriRepo;
    @Autowired
    CalmaListeleriSarkilariRepo calmaListeleriSarkilariRepo;


    //Rastgele Tarih üreten metod
    // Sanatcilar ve Albumler tablosu için oluşturuldu
    public String generateRandomDate() {

        Random random = new Random();
        int year = random.nextInt(50) + 1970;
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(28) + 1;
        LocalDate localDate = LocalDate.of(year, month, day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);

    }

    // Başlangıç ve bitiş adında iki adet int değer arasında rastgele sayı üreten metod
    // Sarkilar tablosunda oluşturulacak rastgele sarkılar adedini belirlemek için kullanıldı
    public int randomSongCount(int start, int end) {
        Random random = new Random();

        for (int i = start; i <= end; i++) {

        }

        int songCount = random.nextInt(end - start + 1) + start;
        return songCount;
    }


    // Uzunluk değeri parametre olarak gelen rastgele String oluşturan metot
    // Tüm db tablolarında Varchar olan bölümlerin rastgele olarak oluşturulması için kullanıldı
    public String generateRandomName(int size) {
        String name = "";
        String alphabet = "abcdefghıijklmnoprstuüvyzABCDEFGHIİOÖPRSŞTUÜVYZ";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            stringBuilder.append(randomChar);
            name = stringBuilder.toString();
        }


        return name;
    }

    public int randomDatabaseSong() {
        Random random = new Random();
        int randomSongDb = random.nextInt((int) (sarkilarRepo.count() - 1 + 1)) + 1;
        return randomSongDb;
    }

    //----------------------------SERVIS 1 -----------------------------------------------------//
    public int sanatciEkle(int albumPiece) {

        String artistName = generateRandomName(5);
        String artitsOrganizationDate = generateRandomDate();

        Sanatcilar sanatcilar1 = new Sanatcilar();
        sanatcilar1.setAd(artistName);
        sanatcilar1.setKurulus_tarihi(artitsOrganizationDate);
        sanatcilarRepo.save(sanatcilar1);


        for (int j = 0; j < albumPiece; j++) {
            int songCount = randomSongCount(6, 15);
            String albumName = generateRandomName(10);
            String albumDate = generateRandomDate();
            Albumler albumler = new Albumler();
            albumler.setAd(albumName);
            albumler.setSanatci_id(sanatcilar1.getId());
            albumler.setCikis_tarihi(albumDate);

            albumlerRepo.save(albumler);

            for (int k = 0; k < songCount; k++) {
                Sarkilar sarkilar = new Sarkilar();
                String sarkiAd = generateRandomName(15);
                sarkilar.setAlbum_id(albumler.getId());
                sarkilar.setSanatci_id(sanatcilar1.getId());
                sarkilar.setAd(sarkiAd);

                sarkilarRepo.save(sarkilar);

            }


        }
        return sanatcilar1.getId();
    }


//--------------------------------------SERVIS 2--------------------------------------------------------//

    public int calmaListesiOlustur(int sarkiAdet, String ad) {
        int playListId = 0; // return olarak dönen calmalistesiId değeri için başlangıçta geçici değer ataması yapıldı

        if (sarkiAdet == 0 || ad.isEmpty()) {
            throw new CustomException("Şarkı adedi sıfır veya ad alanı boş! ");
        } else if (sarkiAdet > sarkilarRepo.count()) {
            throw new CustomException("Listeye eklenmesi istenen şarkı adedi DB deki toplam şarkıdan büyük!");

        } else {

            CalmaListeleri calmaListeleri = new CalmaListeleri();
            calmaListeleri.setAd(ad);
            calmaListeleriRepo.save(calmaListeleri);
            playListId = calmaListeleri.getId(); // kayıt sonrası calmalistesiId değeri bir değişkende tutuldu ve sonrasında return olarak verildi
            for (int i = 0; i < sarkiAdet; i++) {
                CalmaListeleriSarkilari calmaListeleriSarkilari = new CalmaListeleriSarkilari();
                int randomSongDb = randomDatabaseSong(); // sarkilarRepo.count ile db deki şarkıların toplam boyutuna  kadarki sayılar içerisinden rastgele sayı üretildi
                Optional<Sarkilar> songs = sarkilarRepo.findById(randomSongDb); // rastgele üretilen sayı db de bulundu
                calmaListeleriSarkilari.setCalma_listesi_id(calmaListeleri.getId());
                calmaListeleriSarkilari.setSarki_id(songs.get().getId());
                calmaListeleriSarkilariRepo.save(calmaListeleriSarkilari);

            }


        }


        return playListId;
    }


//---------------------------------------------SERVIS 3------------------------------------------------------//

    public void calmaListesiYenile(int calmaListesiId, int yeniSarkiAdet) {

        List<Integer> addSongById = new ArrayList<>();
        for (CalmaListeleriSarkilari calmaListeleriSarkilari : calmaListeleriSarkilariRepo.findAll()) {
            if (calmaListeleriSarkilari.getCalma_listesi_id() == calmaListesiId) {
                addSongById.add(calmaListeleriSarkilari.getSarki_id());
            }
        }

        calmaListeleriSarkilariRepo.deleteByCalmaListesiId(calmaListesiId); // calmaListeleriSarkilariRepo da calmaLİstesiId sine göre satır silen Query metodu mevcuttur.

        for (int i = 0; i < yeniSarkiAdet; i++) {  // Eklemek istediğimiz şarkı adedi kadar döner
            int randomSongDb = randomDatabaseSong();
            for (int j = 0; j < addSongById.size(); j++) {  // önceki çalma listesindeki şarkıların sayısı kadar döner ( şarkıların eşitliğinin kontrolü için )
                if (randomSongDb != addSongById.get(j)) { // random üretilen sayının önceki calma lisesindeki şarkıların id sine eşit olup olmadığının kontrolünü yapar
                    addSongById.add(randomSongDb);
                    CalmaListeleriSarkilari calmaListeleriSarkilari = new CalmaListeleriSarkilari();
                    calmaListeleriSarkilari.setCalma_listesi_id(calmaListesiId);
                    calmaListeleriSarkilari.setSarki_id(randomSongDb);
                    calmaListeleriSarkilariRepo.save(calmaListeleriSarkilari);
                    break;  // şarkı eklendiğinde aynı şarkıyı yeniden eklememesi için döngü kırılır

                }
            }

        }


    }


    //---------------------------------------------SERVIS 4 ( java kodu ve sql kodu olmak üzere 2 farklı şekilde yapılmıştır !)------------------------------------------------------//
    public ResponseArtist sanatciBazliIstatistikAl() {
        ResponseArtist response = new ResponseArtist();
        List<ArtistDetails> artistDetailsList = new ArrayList<>();
        int totalAlbum = 0, totalSong = 0;
        for (Sanatcilar sanatcilar : sanatcilarRepo.findAll()) {
            ArtistDetails artistDetails = new ArtistDetails();
            artistDetails.setArtistName(sanatcilar.getAd());

            for (Albumler albumler : albumlerRepo.findAll()) {
                if (albumler.getSanatci_id() == sanatcilar.getId()) {
                    totalAlbum++;
                }

            }
            for (Sarkilar sarkilar : sarkilarRepo.findAll()) {
                if (sarkilar.getSanatci_id() == sanatcilar.getId()) {
                    totalSong++;
                }

            }
            artistDetails.setArtisAlbumTotal(totalAlbum);
            artistDetails.setCountOfSongsInAlbums(totalSong);
            totalAlbum = 0;
            totalSong = 0;


            artistDetailsList.add(artistDetails);
        }
        response.setArtistDetailsList(artistDetailsList);

        return response;
    }



//-------------SERVIS 4 SQL KOMUTLARI İLE ÇÖZÜMÜ --------------------//

   /* INSERT INTO Sanatci_istatistik(Sanatci_Adi, Toplam_Album_Adedi, Toplam_Sarki_Adedi)
    SELECT
    s.ad as Sanatci_Adi,
    COUNT(DISTINCT a.id) as Toplam_Album_Adedi,
    COUNT(s2.id) as Toplam_Sarki_Adedi


    FROM sanatcilar s
    LEFT JOIN albumler a ON s.id = a.sanatci_id
    LEFT JOIN sarkilar s2 ON a.id = s2.album_id
    GROUP BY s.ad
    ORDER BY COUNT(s2.id) DESC, COUNT(DISTINCT  a.id) ASC;*/



}



