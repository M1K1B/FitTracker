package com.example.demo.dto;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import model.Korisnici;

public class ProfilData {
	private String ime;
	private String prezime;
	private String email;
	private double visina;
	private double tezina;
	private Date datumRodjenja;
	private double bmi;
	private String status;
	private double bmr;
	private int[][] macros;
	
	public ProfilData (Korisnici kor) {
		ime = kor.getIme();
		prezime = kor.getPrezime();
		email = kor.getEmail();
		visina = kor.getVisina();
		tezina = kor.getTezina();
		datumRodjenja = kor.getDatumRodjenja();
		
		macros = new int[5][4];
		
		
		bmi = Math.round((tezina / (visina/100*visina/100))*100.0)/100.0;
		
		if (bmi < 18.5) status = "podhranjeni";
		else if (bmi >= 18.5 && bmi < 25 ) status = "normalne težine";
		else if (bmi >= 25 && bmi < 30) status = "prekomerne težine";
		else status = "gojazni";
		
		bmr = 10 * tezina + 6.25 * visina - 5 * calculateAge(datumRodjenja) + 5;
		
		macros[2][0] = (int)(bmr * 1.375);
		macros[0][0] = (int)(macros[2][0] * 1.2);
		macros[1][0] = (int)(macros[2][0] * 1.1);
		macros[3][0] = (int)(macros[2][0] * 0.9);
		macros[4][0] = (int)(macros[2][0] * 0.8);
		
		for (int i = 0; i < 5; i++) {
			macros[i][1] = (int)((macros[i][0]*0.20)/4);
			macros[i][2] = (int)((macros[i][0]*0.25)/9);
			macros[i][3] = (int)((macros[i][0]*0.55)/4);
		}
	}
	
	private int calculateAge(Date dateOfBirth) {
        if (dateOfBirth == null) {
            throw new IllegalArgumentException("Date of birth cannot be null");
        }

        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate(), currentDate).getYears();
    }
	
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
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getBmr() {
		return bmr;
	}
	public void setBmr(double bmr) {
		this.bmr = bmr;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public int[][] getMacros() {
		return macros;
	}

	public void setMacros(int[][] macros) {
		this.macros = macros;
	}
	
}