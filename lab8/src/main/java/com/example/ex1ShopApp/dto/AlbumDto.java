package com.example.ex1ShopApp.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AlbumDto {
    @NotNull
    @NotBlank
    private String albumName;
    @NotNull
    @NotBlank
    private int albumQuantity;
    @JsonIgnore
    private AlbumDetailsDto albumDetails;
    @JsonIgnore
    private ArtistDto artist;
    @JsonIgnore
    private List<ShopDto> shops = new ArrayList<>();

}
