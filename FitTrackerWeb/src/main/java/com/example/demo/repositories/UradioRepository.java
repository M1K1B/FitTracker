package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Uradio;

public interface UradioRepository extends JpaRepository<Uradio, Integer> {
	@Modifying
	@Query("DELETE FROM Uradio u WHERE u.treninzi.idTreninga = :trId")
	void deleteByTreningId (@Param("trId") Integer id);
}