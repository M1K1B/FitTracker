package com.example.demo.dto;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class VezbaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Naziv ne sme biti prazan.")
	private String naziv;
	
	@Min(value = 0, message = "Morate odabrati mišić.")
	private int misicId;
	
	private int ocena;
	
	@NotEmpty(message = "Opis ne sme biti prazan.")
	private String opis;
	
	private MultipartFile slika;
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getMisicId() {
		return misicId;
	}
	public void setMisicId(int misicId) {
		this.misicId = misicId;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public MultipartFile getSlika() {
		return slika;
	}
	public void setSlika(MultipartFile slika) {
		this.slika = slika;
	}
}