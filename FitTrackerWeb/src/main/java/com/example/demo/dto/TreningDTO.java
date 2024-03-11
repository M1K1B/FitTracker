package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.example.demo.misc.PositiveIntArray;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public class TreningDTO {
	
	@NotEmpty(message = "Naziv ne sme biti prazan.")
	private String naziv;
	
	@PastOrPresent(message="Datum mora biti današnji ili iz prošlosti.")
	private Date datum;
	
	@PositiveIntArray
	private int[] idVezbi;
	
	private int[] serije;
	
	private int[] ponavljanja;
	
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	public int[] getIdVezbi() {
		return idVezbi;
	}
	public void setIdVezbi(int[] idVezbi) {
		this.idVezbi = idVezbi;
	}
	public int[] getSerije() {
		return serije;
	}
	public void setSerije(int[] serije) {
		this.serije = serije;
	}
	public int[] getPonavljanja() {
		return ponavljanja;
	}
	public void setPonavljanja(int[] ponavljanja) {
		this.ponavljanja = ponavljanja;
	}
	@Override
	public String toString() {
		return "TreningDTO [naziv=" + naziv + ", datum=" + datum + ", idVezbi=" + Arrays.toString(idVezbi) + ", serije="
				+ Arrays.toString(serije) + ", ponavljanja=" + Arrays.toString(ponavljanja) + "]";
	}
	
}