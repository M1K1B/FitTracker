package com.example.demo.dto;

import java.util.Date;

public class KorisnikDTO {
	private String ime;
	private String prezime;
	private String email;
	private String lozinka;
	private double visina;
	private double tezina;
	private Date datumRodjenja;
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public double getVisina() {
		return visina;
	}
	public void setVisina(double visina) {
		this.visina = visina;
	}
	public double getTezina() {
		return tezina;
	}
	public void setTezina(double tezina) {
		this.tezina = tezina;
	}
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	
}