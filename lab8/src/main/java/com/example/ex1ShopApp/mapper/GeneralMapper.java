package com.example.ex1ShopApp.mapper;

import com.example.ex1ShopApp.dto.AlbumDetailsDto;
import com.example.ex1ShopApp.dto.AlbumDto;
import com.example.ex1ShopApp.dto.ArtistDto;
import com.example.ex1ShopApp.dto.ShopDto;
import com.example.ex1ShopApp.model.Album;
import com.example.ex1ShopApp.model.AlbumDetails;
import com.example.ex1ShopApp.model.Artist;
import com.example.ex1ShopApp.model.Shop;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneralMapper {

    public Album toAlbum(AlbumDto albumDto) {
        List<ShopDto> shopDtos = albumDto.getShops();
        List<Shop> shops = new ArrayList<>();
        for (ShopDto shopDto : shopDtos) {
            shops.add(toShop(shopDto));
        }

        return Album.builder()
//                .artist(toArtist(albumDto.getArtist()))
                .albumQuantity(albumDto.getAlbumQuantity())
                .albumName(albumDto.getAlbumName())
//                .albumDetails(toAlbumDetails(albumDto.getAlbumDetails()))
//                .shops(shops)
                .build();
    }

    public AlbumDto toAlbumDto(Album album) {

//        List<Shop> shops = album.getShops();
//        List<ShopDto> shopsDto = new ArrayList<>();
//        for (Shop shop : shops) {
//            shopsDto.add(toShopDto(shop));
//        }

        return AlbumDto.builder()
                .artist(toArtistDto(album.getArtist()))
                .albumQuantity(album.getAlbumQuantity())
                .albumDetails(toAlbumDetailsDto(album.getAlbumDetails()))
                .albumName(album.getAlbumName())
//                .shops(shopsDto)
                .build();
    }

    public ShopDto toShopDto(Shop shop) {

        List<AlbumDto> albumDtos = new ArrayList<>();
        for (Album album : shop.getAlbumList()) {
            albumDtos.add(toAlbumDto(album));
        }

        return ShopDto.builder()
                .albumList(albumDtos)
                .location(shop.getLocation())
                .build();
    }

    public Shop toShop(ShopDto shopDto) {

        List<Album> albumList = new ArrayList<>();
        for (AlbumDto albumDto : shopDto.getAlbumList()) {
            albumList.add(toAlbum(albumDto));
        }

        return Shop.builder()
                .albumList(albumList)
                .location(shopDto.getLocation())
                .build();
    }

    public Artist toArtist(ArtistDto artistDto) {
        return Artist.builder()
                .artistName(artistDto.getArtistName())
                .build();
    }

    public ArtistDto toArtistDto(Artist artist) {
        return ArtistDto.builder()
                .artistName(artist.getArtistName())
                .build();
    }


    public AlbumDetails toAlbumDetails(AlbumDetailsDto albumDetailsDto) {
        return AlbumDetails.builder()
                .description(albumDetailsDto.getDescription())
                .build();
    }

    public AlbumDetailsDto toAlbumDetailsDto(AlbumDetails albumDetails) {
        return AlbumDetailsDto.builder()
                .description(albumDetails.getDescription())
                .build();
    }
}
