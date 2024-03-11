package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Pogadja;
import model.Vezbe;

public interface PogadjaRepository extends JpaRepository<Pogadja, Integer> {
	@Query("SELECT p.vezbe FROM Pogadja p WHERE p.misici.idMisica = :misicId")
    List<Vezbe> findVezbeByMisickId(@Param("misicId") int misicId);
}