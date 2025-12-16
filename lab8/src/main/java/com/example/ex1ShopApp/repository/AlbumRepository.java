package com.example.ex1ShopApp.repository;

import com.example.ex1ShopApp.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
