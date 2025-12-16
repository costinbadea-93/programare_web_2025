package com.example.ex1ShopApp.service;


import com.example.ex1ShopApp.model.Album;
import com.example.ex1ShopApp.model.AlbumDetails;
import com.example.ex1ShopApp.model.Artist;
import com.example.ex1ShopApp.repository.AlbumDetailRepository;
import com.example.ex1ShopApp.repository.AlbumRepository;
import com.example.ex1ShopApp.repository.ArtistRepository;
import com.example.ex1ShopApp.repository.ShopRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShopServiceTest {

    @InjectMocks
    private ShopService shopService;

    @Mock
    private AlbumDetailRepository albumDetailRepository;

    @Mock
    private AlbumRepository albumRepository;

    @Mock
    private ArtistRepository artistRepository;

    @Mock
    private ShopRepository shopRepository;


    @Test
    @DisplayName("Running save artist behaviour on happy flow")
    public void saveArtistTest(){
        //arrange
        Artist artist = Artist.builder().artistName("some name").build();
//        Artist artistResponse = new Artist("response artist");
        when(artistRepository.save(artist)).thenReturn(artist);

        //act
        Artist result = shopService.saveArtist(artist);

        //assert
        assertEquals(artist.getArtistName(), result.getArtistName());
    }

    @Test
    public void saveAlbumTest(){
        //arrange
        int albumDetailsId = 1;
        int artistId = 2;

        Album album = Album.builder().albumName("A1").albumId(5).build();
        AlbumDetails albumDetails = AlbumDetails.builder().description("TestAlbumDetails").build();
        Artist artist = Artist.builder().artistName("TestArtist").build();

        when(albumDetailRepository.findById(albumDetailsId)).thenReturn(Optional.of(albumDetails));
        when(artistRepository.findById(artistId)).thenReturn(Optional.of(artist));
        when(albumRepository.save(album)).thenReturn(album);


        //act
        Album result = shopService.saveAlbum(album, albumDetailsId, artistId);

        //assert
        assertEquals(result.getArtist().getArtistName(), artist.getArtistName(), "Should be equals");
    }

    @Test
    public void saveSomeAlbumDetailsTest() {
        //arrange

        //act
        RuntimeException result = assertThrows(
                RuntimeException.class,
                () -> shopService.saveSomeAlbumDetails()
        );

        assertEquals(result.getMessage(), "I = 5!!!!!", "should be equals");
    }
}
