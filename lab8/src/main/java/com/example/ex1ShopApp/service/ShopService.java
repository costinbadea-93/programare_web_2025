package com.example.ex1ShopApp.service;

import com.example.ex1ShopApp.exceptions.EntityNotFoundException;
import com.example.ex1ShopApp.model.Album;
import com.example.ex1ShopApp.model.AlbumDetails;
import com.example.ex1ShopApp.model.Artist;
import com.example.ex1ShopApp.model.Shop;
import com.example.ex1ShopApp.repository.AlbumDetailRepository;
import com.example.ex1ShopApp.repository.AlbumRepository;
import com.example.ex1ShopApp.repository.ArtistRepository;
import com.example.ex1ShopApp.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopService {

    private final AlbumDetailRepository albumDetailRepository;
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final ShopRepository shopRepository;

    public Artist saveArtist(Artist artist){
        return artistRepository.save(artist);
    }

    public AlbumDetails saveAlbumDetails(AlbumDetails albumDetails){
        return albumDetailRepository.save(albumDetails);
    }

    public Album saveAlbum(Album album, int albumDetailsId, int artistId){
        AlbumDetails albumDetails = albumDetailRepository.findById(albumDetailsId)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find album details with id " + albumDetailsId));

        Artist artist = artistRepository.findById(artistId).orElseThrow(() ->
                new EntityNotFoundException("Cannot find artist with id " + artistId));

        album.setAlbumDetails(albumDetails);
        album.setArtist(artist);

        return albumRepository.save(album);
    }

    public Shop saveShop(Shop shop, List<Integer> albumIds){
        List<Album> albums = albumRepository.findAllById(albumIds);
        shop.setAlbumList(albums);
        return shopRepository.save(shop);
    }

    @Transactional
    public void saveSomeAlbumDetails(){
        for(int i = 0 ; i < 10 ; i ++) {
            AlbumDetails albumDetails = AlbumDetails.builder().description("Album " + i).build();
            albumDetailRepository.save(albumDetails);
            if(i == 5) {
                throw new RuntimeException("I = 5!!!!!");
            }
        }
    }

}
