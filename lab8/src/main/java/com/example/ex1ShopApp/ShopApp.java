package com.example.ex1ShopApp;

import com.example.ex1ShopApp.repository.AlbumRepository;
import com.example.ex1ShopApp.repository.ShopRepository;
import com.example.ex1ShopApp.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApp implements CommandLineRunner {

    @Autowired
    private ShopService shopService;
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private ShopRepository shopRepository;


    public static void main(String[] args) {
        SpringApplication.run(ShopApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Artist artist1 = new Artist("A1");
//        Artist artist2 = new Artist("A2");
//
//        shopService.saveArtist(artist1);
//        shopService.saveArtist(artist2);
//
//        AlbumDetails albumDetails1 = new AlbumDetails("Some album details1 description");
//        AlbumDetails albumDetails2 = new AlbumDetails("Some album details2 description");
//
//        shopService.saveAlbumDetails(albumDetails1);
//        shopService.saveAlbumDetails(albumDetails2);
//
//        Album album1 = new Album("Album1", 5);
//        Album album2 = new Album("Album2", 6);
//
//        album1.setAlbumDetails(albumDetails1);
//        album2.setAlbumDetails(albumDetails2);
//
//        album1.setArtist(artist1);
//        album2.setArtist(artist2);
//
//        albumRepository.save(album1);
//        albumRepository.save(album2);
//
//        Shop shop = new Shop("Bucuresti sector 3");
//        shop.setAlbumList(Arrays.asList(album1,album2));
//
//        shopRepository.save(shop);

        //ACID =>
        // -ATOMIC
        // -CONSISTENT
        // -IZOLAT
        // -DURABIL

//        shopService.saveSomeAlbumDetails();

    }
}
