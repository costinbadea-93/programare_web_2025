package com.example.ex1ShopApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AlbumDetailsDto {

    @NotNull(message = "Album description cannot be null")
    private String description;
}