package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Omiljene;
import model.Vezbe;

public interface OmiljeneRepository extends JpaRepository<Omiljene, Integer> {
	@Query("SELECT o.vezbe FROM Omiljene o WHERE o.korisnici.idKorisnika = :korisnikId")
    List<Vezbe> findVezbeByKorisnikId(@Param("korisnikId") int korisnikId);
	
	@Modifying
	@Query("delete from Omiljene o WHERE o.korisnici.idKorisnika = :korisnikId and o.vezbe.idVezbe = :vezbaId")
	void deleteByVezbaAndKorisnik (@Param("vezbaId") int vezbaId, @Param("korisnikId") int korisnikId);
}