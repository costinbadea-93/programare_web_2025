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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtistDto {
    @NotNull
    @NotBlank
    private String artistName;
    @JsonIgnore
    private List<AlbumDto> albumList = new ArrayList<>();
}
