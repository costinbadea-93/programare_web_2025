package com.example.ex1ShopApp.controller;

import com.example.ex1ShopApp.dto.AlbumDetailsDto;
import com.example.ex1ShopApp.mapper.GeneralMapper;
import com.example.ex1ShopApp.model.AlbumDetails;
import com.example.ex1ShopApp.repository.AlbumDetailRepository;
import com.example.ex1ShopApp.repository.AlbumRepository;
import com.example.ex1ShopApp.repository.ArtistRepository;
import com.example.ex1ShopApp.repository.ShopRepository;
import com.example.ex1ShopApp.service.ShopService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(ShopServiceController.class)
public class ShopControllerIT {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper= new ObjectMapper();

    @MockBean
    private ShopService shopService;

    @MockBean
    private GeneralMapper generalMapper;

    @MockBean
    private AlbumDetailRepository albumDetailRepository;

    @MockBean
    private AlbumRepository albumRepository;

    @MockBean
    private ArtistRepository artistRepository;

    @MockBean
    private ShopRepository shopRepository;

    @Test
    public void createAlbumDetails() throws Exception {
        //arrange
        AlbumDetails albumDetails = new AlbumDetails(1,"some description");
        com.example.ex1ShopApp.dto.AlbumDetailsDto  albumDetailsDto = new AlbumDetailsDto("some description");
        //if we dont want to use any we have to override equals and hash code in AlbumDetails
        //because we serialize/deserialize a copy of the object from test and not
        //the initial one
        when(generalMapper.toAlbumDetailsDto(any())).thenReturn(albumDetailsDto);
        when(shopService.saveAlbumDetails(any())).thenReturn(albumDetails);

        //act
        //assert
        mockMvc.perform(
                post("/shops/albumDetails/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(albumDetails))
        ).andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(jsonPath("$.description").value(albumDetails.getDescription()));
    }

}
