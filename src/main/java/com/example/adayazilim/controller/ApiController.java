package com.example.adayazilim.controller;




import com.example.adayazilim.model.responseArtist.ResponseArtist;
import com.example.adayazilim.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    ApiService apiService;



    @PostMapping("/addArtist")
    public int artistAddMethod(@RequestParam int albumAdet){
        return apiService.sanatciEkle(albumAdet);
    }
    @PostMapping("/createPlaylist")
    public int createPlaylistMethod(@RequestParam int sarkiAdet, @RequestParam String ad ){
        return apiService.calmaListesiOlustur(sarkiAdet,ad);
    }

    @PostMapping("/refreshPlayList")
    public void refreshPlayListMethod(@RequestParam int calmaListesiId, @RequestParam int yeniSarkiAdet){
         apiService.calmaListesiYenile(calmaListesiId, yeniSarkiAdet);
    }

    @PostMapping("/artistStatistics")
    public ResponseArtist artistStatisticsMethod(){
        return apiService.sanatciBazliIstatistikAl();
    }





}
