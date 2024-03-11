package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Vezbe;

public interface VezbeRepository extends JpaRepository<Vezbe, Integer> {
	@Query("SELECT v FROM Vezbe v WHERE v.naziv LIKE :query")
	List<Vezbe> findAllBySearchQuery (@Param("query") String query);
	
	
}