package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Treninzi;

public interface TreninziRepository extends JpaRepository<Treninzi, Integer> {
	@Query("select t from Treninzi t where t.korisnici.idKorisnika = :userId")
	List<Treninzi> findAllByUser(@Param("userId") Integer userId);
}