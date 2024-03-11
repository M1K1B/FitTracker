package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.Korisnici;

@Repository
public interface KorisniciRepository extends JpaRepository<Korisnici, Integer> {
	@Query("select u from Korisnici u where u.email=:email")
	public Korisnici findByUsername(@Param("email") String email);
}