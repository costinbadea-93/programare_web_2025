package com.example.ex1ShopApp.repository;

import com.example.ex1ShopApp.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}
