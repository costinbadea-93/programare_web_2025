package com.example.ex1ShopApp.repository;

import com.example.ex1ShopApp.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
