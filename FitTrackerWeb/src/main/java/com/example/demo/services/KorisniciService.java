package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.KorisnikDTO;
import com.example.demo.repositories.KorisniciRepository;
import model.Korisnici;


@Service
public class KorisniciService {
	@Autowired
	KorisniciRepository kr;
	

	public int uploadKorisnik(KorisnikDTO korisnik) {
		Korisnici novi = new Korisnici();

		novi.setIme(korisnik.getIme());
		novi.setPrezime(korisnik.getPrezime());
		novi.setEmail(korisnik.getEmail());
		novi.setLozinka(com.example.demo.security.PasswordEncoder.encode(korisnik.getLozinka()));
		novi.setVisina(korisnik.getVisina());
		novi.setTezina(korisnik.getTezina());
		novi.setDatumRodjenja(korisnik.getDatumRodjenja());

		try {
			Korisnici nk = kr.save(novi);
			
			return nk.getIdKorisnika();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public Korisnici getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		return kr.findByUsername(auth.getName());
	}
}