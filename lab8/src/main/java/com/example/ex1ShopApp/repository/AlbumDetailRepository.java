package com.example.ex1ShopApp.repository;

import com.example.ex1ShopApp.model.AlbumDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumDetailRepository extends JpaRepository<AlbumDetails, Integer> {
}
