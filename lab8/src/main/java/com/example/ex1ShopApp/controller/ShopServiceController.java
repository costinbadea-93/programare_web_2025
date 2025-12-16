package com.example.ex1ShopApp.controller;

import com.example.ex1ShopApp.dto.AlbumDetailsDto;
import com.example.ex1ShopApp.dto.AlbumDto;
import com.example.ex1ShopApp.dto.ArtistDto;
import com.example.ex1ShopApp.dto.ShopDto;
import com.example.ex1ShopApp.mapper.GeneralMapper;
import com.example.ex1ShopApp.model.Shop;
import com.example.ex1ShopApp.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shops")
@RequiredArgsConstructor
public class ShopServiceController {

    private final ShopService shopService;
    private final GeneralMapper generalMapper;

    @PostMapping("/artist/new")
    public ResponseEntity<ArtistDto> saveArtist(@RequestBody ArtistDto artistDto){
       ArtistDto savedArtist = generalMapper.toArtistDto(shopService.saveArtist(generalMapper.toArtist(artistDto)));
        return ResponseEntity.ok().body(savedArtist);
    }

    @PostMapping("/albumDetails/new")
    public ResponseEntity<AlbumDetailsDto> saveAlbumDetails(@RequestBody AlbumDetailsDto albumDetailsDto){
        AlbumDetailsDto savedAlbumDetails =
                generalMapper.toAlbumDetailsDto(shopService.saveAlbumDetails(generalMapper.toAlbumDetails(albumDetailsDto)));

        return ResponseEntity.ok().body(savedAlbumDetails);
    }

    @PostMapping("/album/new")
    public ResponseEntity<AlbumDto> saveAlbum(@RequestBody AlbumDto albumDto,
                                              @RequestParam int albumDetailsId,
                                              @RequestParam int artistId){
        return ResponseEntity.ok()
                .body(generalMapper.toAlbumDto(shopService.saveAlbum(generalMapper.toAlbum(albumDto), albumDetailsId, artistId)));
    }

    @PostMapping("/shop/new")
    public ResponseEntity<ShopDto> saveShop(@RequestBody ShopDto shop,
                                            @RequestParam List<Integer> albumDetailsId){
        return ResponseEntity.ok().body(generalMapper.toShopDto(shopService.saveShop(generalMapper.toShop(shop),albumDetailsId)));
    }
}
